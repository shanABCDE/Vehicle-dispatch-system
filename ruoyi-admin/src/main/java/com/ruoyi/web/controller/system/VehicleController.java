package com.ruoyi.web.controller.system;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.Driver;
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
import com.ruoyi.system.domain.Vehicle;
import com.ruoyi.system.service.IVehicleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【功能】Controller
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
@RestController
@RequestMapping("/system/vehicle")
public class VehicleController extends BaseController
{
    @Autowired
    private IVehicleService vehicleService;

    /**
     * 查询
     */
    @PreAuthorize("@ss.hasPermi('system:vehicle:list')")
    @GetMapping("/list")
    public TableDataInfo list(Vehicle vehicle)
    {
        startPage();
        List<Vehicle> list = vehicleService.selectVehicleList(vehicle);
        return getDataTable(list);
    }

    @GetMapping("getVehicle")
    public AjaxResult getVehicle (){
        ArrayList<Vehicle> vehicles1 = new ArrayList<>();
        List<Vehicle> vehicles = vehicleService.selectVehicleList(null);
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getState()==0) {
                vehicles1.add(vehicle);
            }
        }
        return AjaxResult.success(vehicles1);
    }


    /**
     * 导出
     */
    @PreAuthorize("@ss.hasPermi('system:vehicle:export')")
    @Log(title = "导出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Vehicle vehicle)
    {
        List<Vehicle> list = vehicleService.selectVehicleList(vehicle);
        ExcelUtil<Vehicle> util = new ExcelUtil<Vehicle>(Vehicle.class);
        util.exportExcel(response, list, "导出数据");
    }

    /**
     * 获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:vehicle:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(vehicleService.selectVehicleById(id));
    }

    /**
     * 添加
     */
    @PreAuthorize("@ss.hasPermi('system:vehicle:add')")
    @Log(title = "添加", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Vehicle vehicle)
    {
        return toAjax(vehicleService.insertVehicle(vehicle));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('system:vehicle:edit')")
    @Log(title = "修改", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Vehicle vehicle)
    {
        return toAjax(vehicleService.updateVehicle(vehicle));
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('system:vehicle:remove')")
    @Log(title = "删除", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(vehicleService.deleteVehicleByIds(ids));
    }
}
