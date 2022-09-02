package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.Clientele;
import com.ruoyi.system.service.IClienteleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【功能】Controller
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
@RestController
@RequestMapping("/system/clientele")
public class ClienteleController extends BaseController
{
    @Autowired
    private IClienteleService clienteleService;

    /**
     * 查询
     */
    @PreAuthorize("@ss.hasPermi('system:clientele:list')")
    @GetMapping("/list")
    public TableDataInfo list(Clientele clientele)
    {
        startPage();
        List<Clientele> list = clienteleService.selectClienteleList(clientele);
        return getDataTable(list);
    }

    /**
     * 导出
     */
    @PreAuthorize("@ss.hasPermi('system:clientele:export')")
    @Log(title = "导出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Clientele clientele)
    {
        List<Clientele> list = clienteleService.selectClienteleList(clientele);
        ExcelUtil<Clientele> util = new ExcelUtil<Clientele>(Clientele.class);
        util.exportExcel(response, list, "导出数据");
    }

    /**
     * 获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:clientele:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(clienteleService.selectClienteleById(id));
    }

    /**
     * 添加
     */
    @PreAuthorize("@ss.hasPermi('system:clientele:add')")
    @Log(title = "添加", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Clientele clientele)
    {
        return toAjax(clienteleService.insertClientele(clientele));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('system:clientele:edit')")
    @Log(title = "修改", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Clientele clientele)
    {
        return toAjax(clienteleService.updateClientele(clientele));
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('system:clientele:remove')")
    @Log(title = "删除", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(clienteleService.deleteClienteleByIds(ids));
    }
}
