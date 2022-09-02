package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.Driver;
import com.ruoyi.system.service.IDriverService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【功能】Controller
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
@RestController
@RequestMapping("/system/driver")
public class DriverController extends BaseController
{
    @Autowired
    private IDriverService driverService;

    /**
     * 查询
     */
    @PreAuthorize("@ss.hasPermi('system:driver:list')")
    @GetMapping("/list")
    public TableDataInfo list(Driver driver)
    {
        startPage();
        List<Driver> list = driverService.selectDriverList(driver);
        return getDataTable(list);
    }

    //订单表获取信息
   @GetMapping("/getDriver")
   public AjaxResult getDriver(){
       Driver driver = new Driver();
       driver.setState(0l);
       List<Driver> drivers = driverService.selectDriverList(driver);

       return AjaxResult.success(drivers);
   }


    /**
     * 导出
     */
    @PreAuthorize("@ss.hasPermi('system:driver:export')")
    @Log(title = "导出司机信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Driver driver)
    {
        List<Driver> list = driverService.selectDriverList(driver);
        ExcelUtil<Driver> util = new ExcelUtil<Driver>(Driver.class);
        util.exportExcel(response, list, "导出数据");
    }

    /**
     * 获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:driver:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(driverService.selectDriverById(id));
    }

    /**
     * 添加
     */
    @PreAuthorize("@ss.hasPermi('system:driver:add')")
    @Log(title = "添加", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Driver driver)
    {
        return toAjax(driverService.insertDriver(driver));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('system:driver:edit')")
    @Log(title = "修改", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Driver driver)
    {
        return toAjax(driverService.updateDriver(driver));
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('system:driver:remove')")
    @Log(title = "删除", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(driverService.deleteDriverByIds(ids));
    }
}
