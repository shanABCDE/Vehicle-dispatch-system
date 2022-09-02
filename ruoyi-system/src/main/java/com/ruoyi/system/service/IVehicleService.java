package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Vehicle;

/**
 * 【功能】Service接口
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
public interface IVehicleService 
{
    /**
     * 查询【功能】
     * 
     * @param id 【功能】主键
     * @return 【功能】
     */
    public Vehicle selectVehicleById(Long id);

    /**
     * 查询
     * 
     * @param vehicle 【功能】
     * @return 【功能】集合
     */
    public List<Vehicle> selectVehicleList(Vehicle vehicle);

    /**
     * 新增【功能】
     * 
     * @param vehicle 【功能】
     * @return 结果
     */
    public int insertVehicle(Vehicle vehicle);

    /**
     * 修改【功能】
     * 
     * @param vehicle 【功能】
     * @return 结果
     */
    public int updateVehicle(Vehicle vehicle);

    /**
     * 批量删除【功能】
     * 
     * @param ids 需要删除的【功能】主键集合
     * @return 结果
     */
    public int deleteVehicleByIds(Long[] ids);

    /**
     * 删除【功能】信息
     * 
     * @param id 【功能】主键
     * @return 结果
     */
    public int deleteVehicleById(Long id);
}
