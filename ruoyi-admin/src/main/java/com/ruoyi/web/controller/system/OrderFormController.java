package com.ruoyi.web.controller.system;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.Clientele;
import com.ruoyi.system.domain.Driver;
import com.ruoyi.system.domain.Vehicle;
import com.ruoyi.system.domain.vo.OrderFormVo;
import com.ruoyi.system.service.IClienteleService;
import com.ruoyi.system.service.IDriverService;
import com.ruoyi.system.service.IVehicleService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.OrderForm;
import com.ruoyi.system.service.IOrderFormService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【功能】Controller
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
@RestController
@RequestMapping("/system/form")
public class OrderFormController extends BaseController
{
    @Autowired
    private IOrderFormService orderFormService;
    @Autowired
    private IVehicleService vehicleService;
    @Autowired
    private IDriverService driverService;
    @Autowired
    private IClienteleService clienteleService;

    /**
     * 查询
     */
    @PreAuthorize("@ss.hasPermi('system:form:list')")
    @GetMapping("/list")
    public AjaxResult list(OrderForm orderForm)
    {
        startPage();
        List<OrderForm> list = orderFormService.selectOrderFormList(orderForm);
        ArrayList<OrderFormVo> orderFormVos = new ArrayList<>();
        for (OrderForm form : list) {
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


          return AjaxResult.success(getDataTable(list)).put("orderFormVos",orderFormVos);
    }

    /**
     * 导出
     */
    @PreAuthorize("@ss.hasPermi('system:form:export')")
    @Log(title = "导出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrderForm orderForm)
    {
        List<OrderForm> list = orderFormService.selectOrderFormList(orderForm);
        ExcelUtil<OrderForm> util = new ExcelUtil<OrderForm>(OrderForm.class);
        util.exportExcel(response, list, "导出数据");
    }


    /**
     * 获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:form:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(orderFormService.selectOrderFormById(id));
    }


    /**
     * 添加
     */
    @PreAuthorize("@ss.hasPermi('system:form:add')")
    @Log(title = "添加", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderForm orderForm)
    {
        return toAjax(orderFormService.insertOrderForm(orderForm));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('system:form:edit')")
    @Log(title = "修改", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrderForm orderForm)

    {
        //司机
        orderForm.setState("1");
        Driver driver = new Driver();
        driver.setState(1l);
        driver.setId(orderForm.getDriverId());
        driverService.updateDriver(driver);

        //车辆
        Vehicle vehicle = new Vehicle();
        vehicle.setState(1l);
        vehicle.setId(orderForm.getDriverId());
        vehicleService.updateVehicle(vehicle);

        return toAjax(orderFormService.updateOrderForm(orderForm));
    }

    //归还
    @PutMapping("giveBack")
    public AjaxResult giveBack(@RequestBody OrderForm orderForm)

    {
        orderForm.setState("2");
        //司机
        Driver driver = new Driver();
        driver.setState(0l);
        driver.setId(orderForm.getDriverId());
        driverService.updateDriver(driver);

        //车辆
        Vehicle vehicle = new Vehicle();
        vehicle.setState(0l);
        vehicle.setId(orderForm.getDriverId());
        vehicleService.updateVehicle(vehicle);

        Clientele clientele = clienteleService.selectClienteleById(orderForm.getClienteleId());
        long l = clientele.getBalance() - orderForm.getSum();
        clientele.setBalance(l);
        clienteleService.updateClientele(clientele);

        return toAjax(orderFormService.updateOrderForm(orderForm));
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('system:form:remove')")
    @Log(title = "删除", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(orderFormService.deleteOrderFormByIds(ids));
    }
}
