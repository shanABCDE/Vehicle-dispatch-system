package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.VehicleMapper;
import com.ruoyi.system.domain.Vehicle;
import com.ruoyi.system.service.IVehicleService;

/**
 * 【功能】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
@Service
public class VehicleServiceImpl implements IVehicleService 
{
    @Autowired
    private VehicleMapper vehicleMapper;

    /**
     * 查询【功能】
     * 
     * @param id 【功能】主键
     * @return 【功能】
     */
    @Override
    public Vehicle selectVehicleById(Long id)
    {
        return vehicleMapper.selectVehicleById(id);
    }

    /**
     * 查询
     * 
     * @param vehicle 【功能】
     * @return 【功能】
     */
    @Override
    public List<Vehicle> selectVehicleList(Vehicle vehicle)
    {
        return vehicleMapper.selectVehicleList(vehicle);
    }

    /**
     * 新增【功能】
     * 
     * @param vehicle 【功能】
     * @return 结果
     */
    @Override
    public int insertVehicle(Vehicle vehicle)
    {
        vehicle.setCreateTime(DateUtils.getNowDate());
        return vehicleMapper.insertVehicle(vehicle);
    }

    /**
     * 修改【功能】
     * 
     * @param vehicle 【功能】
     * @return 结果
     */
    @Override
    public int updateVehicle(Vehicle vehicle)
    {
        return vehicleMapper.updateVehicle(vehicle);
    }

    /**
     * 批量删除【功能】
     * 
     * @param ids 需要删除的【功能】主键
     * @return 结果
     */
    @Override
    public int deleteVehicleByIds(Long[] ids)
    {
        return vehicleMapper.deleteVehicleByIds(ids);
    }

    /**
     * 删除【功能】信息
     * 
     * @param id 【功能】主键
     * @return 结果
     */
    @Override
    public int deleteVehicleById(Long id)
    {
        return vehicleMapper.deleteVehicleById(id);
    }
}
