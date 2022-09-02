package com.ruoyi.web.controller.common;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.Clientele;
import com.ruoyi.system.domain.Driver;
import com.ruoyi.system.domain.OrderForm;
import com.ruoyi.system.domain.Vehicle;
import com.ruoyi.system.domain.vo.OrderFormVo;
import com.ruoyi.system.service.IClienteleService;
import com.ruoyi.system.service.IDriverService;
import com.ruoyi.system.service.IOrderFormService;
import com.ruoyi.system.service.IVehicleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Xw")
public class wxController {

    @Autowired
    private IOrderFormService orderFormService;
    @Autowired
    private IVehicleService vehicleService;
    @Autowired
    private IDriverService driverService;
    @Autowired
    private IClienteleService clienteleService;
    @PostMapping("/login")
    public AjaxResult login(@RequestBody Clientele clientele){

        List<Clientele> clienteles = clienteleService.selectClienteleList(clientele);
        if (clienteles.size()==0) {
            Clientele clientele2 = new Clientele();
            clientele2.setName(clientele.getName());
            List<Clientele> clienteles1 = clienteleService.selectClienteleList(clientele2);
            if (clienteles1.size()==0) {
                return AjaxResult.error("用户不存在，请去注册");
            }
            return AjaxResult.error("密码错误");
        }
        return AjaxResult.success("1").put("clientele1",clienteles.get(0));


    }

    @PostMapping("/add")
    public AjaxResult add(@RequestBody Clientele clientele){
        Clientele clientele1 = new Clientele();
        clientele1.setName(clientele.getName());
        int size = clienteleService.selectClienteleList(clientele1).size();
        if (size==0) {
            int i = clienteleService.insertClientele(clientele);
            if (i==1) {
                return AjaxResult.success("增加成功");
            }
            return AjaxResult.error("注册失败");
        }
        return AjaxResult.error("用户已经存在，请更换");
    }


    //小程序端统计
    @GetMapping("/statistics")
    public AjaxResult statistics( String id){
        OrderForm orderForm = new OrderForm();
        long idx= Long.parseLong(id);
        orderForm.setClienteleId(idx);
        List<OrderForm> orderForms = orderFormService.selectOrderFormList(orderForm);
        int po=orderForms.size();
        int end=0;
        int centr=0;
        int achieve=0;
        for (OrderForm form : orderForms) {
            if (form.getState().equals("0")) {
                  end++;
            }
            if (form.getState().equals("1")) {
                  centr++;
            }    if (form.getState().equals("2")) {
                   achieve++;
            }

        }
        Clientele clientele = clienteleService.selectClienteleById(idx);
        Long balance = clientele.getBalance();
        return AjaxResult.success().put("po",po).put("end",end).put("centr",centr).put("achieve",achieve).put("balance",balance);
    }


    // 小程序端充值
   @GetMapping("/recharge")
    public AjaxResult recharge(String id,Integer balance){
        long idx= Long.parseLong(id);
        Clientele clientele = clienteleService.selectClienteleById(idx);
        long l = clientele.getBalance() + balance;
        clientele.setBalance(l);
        clienteleService.updateClientele(clientele);
        return AjaxResult.success();
    }



    @PostMapping("/Overbooking")
    public AjaxResult Overbooking(@RequestBody OrderForm orderForm){
        orderForm.setState("1");

        List<OrderForm> orderForms = orderFormService.selectOrderFormList(orderForm);
        orderForm.setState("2");
        List<OrderForm> orderForms1 = orderFormService.selectOrderFormList(orderForm);
        orderForms.addAll(orderForms1);
        long balance=0;
        for (OrderForm form : orderForms) {
            balance=balance+form.getSum();
        }

        Clientele clientele = clienteleService.selectClienteleById(orderForm.getClienteleId());
        long l = clientele.getBalance() - balance;
        if (l>orderForm.getSum()) {
            orderForm.setState("0");
            orderFormService.insertOrderForm(orderForm);
            return AjaxResult.success();
        }
            return AjaxResult.error();

    }

    @GetMapping("viewDetails")
    private AjaxResult viewDetails(OrderForm orderForm){

        List<OrderForm> orderForms = orderFormService.selectOrderFormList(orderForm);
        ArrayList<OrderFormVo> orderFormVos = new ArrayList<>();
        for (OrderForm form : orderForms) {
            OrderFormVo orderFormVo = new OrderFormVo();
            BeanUtils.copyProperties( form,orderFormVo);
            //客户
            Long clienteleId = form.getClienteleId();
            if (clienteleId!=0) {
                Clientele clientele = clienteleService.selectClienteleById(clienteleId);
                orderFormVo.setClienteleName(clientele.getName());
                orderFormVo.setClienteleRelation(clientele.getRelation());
            }
            //驾驶员"
            Long driverId = form.getDriverId();
            if (driverId!=0) {
                Driver driver = driverService.selectDriverById(driverId);
                orderFormVo.setDriverName(driver.getName());
                orderFormVo.setDriverRelation(driver.getRelation());
            }
            //车辆
            Long vehicleId = form.getVehicleId();
            if (vehicleId!=0) {
                Vehicle vehicle = vehicleService.selectVehicleById(vehicleId);
                orderFormVo.setVehicleLicencePlate(vehicle.getLicencePlate());
                orderFormVo.setVehicleMotorcycleType(vehicle.getMotorcycleType());
            }
            orderFormVos.add(orderFormVo);

        }

        return AjaxResult.success(orderFormVos);

    }

}
