package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Driver;

/**
 * 【功能】Service接口
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
public interface IDriverService 
{
    /**
     * 查询【功能】
     * 
     * @param id 【功能】主键
     * @return 【功能】
     */
    public Driver selectDriverById(Long id);

    /**
     * 查询获取详细信息
     * 
     * @param driver 【功能】
     * @return 【功能】集合
     */
    public List<Driver> selectDriverList(Driver driver);

    /**
     * 新增【功能】
     * 
     * @param driver 【功能】
     * @return 结果
     */
    public int insertDriver(Driver driver);

    /**
     * 修改【功能】
     * 
     * @param driver 【功能】
     * @return 结果
     */
    public int updateDriver(Driver driver);

    /**
     * 批量删除【功能】
     * 
     * @param ids 需要删除的【功能】主键集合
     * @return 结果
     */
    public int deleteDriverByIds(Long[] ids);

    /**
     * 删除【功能】信息
     * 
     * @param id 【功能】主键
     * @return 结果
     */
    public int deleteDriverById(Long id);

    List<Driver> sectDriverList();
}
