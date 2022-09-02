package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Driver;

/**
 * 【功能】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
public interface DriverMapper 
{
    /**
     * 查询
     * 
     * @param id 【功能】主键
     * @return
     */
    public Driver selectDriverById(Long id);

    /**
     * 查询
     * 
     * @param driver
     * @return 集合
     */
    public List<Driver> selectDriverList(Driver driver);

    /**
     * 添加
     * 
     * @param driver
     * @return 结果
     */
    public int insertDriver(Driver driver);

    /**
     * 修改
     * 
     * @param driver
     * @return 结果
     */
    public int updateDriver(Driver driver);

    /**
     * 删除
     * 
     * @param id 主键
     * @return 结果
     */
    public int deleteDriverById(Long id);

    /**
     * 批量删除
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDriverByIds(Long[] ids);
}
