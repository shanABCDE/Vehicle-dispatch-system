package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DriverMapper;
import com.ruoyi.system.domain.Driver;
import com.ruoyi.system.service.IDriverService;

/**
 * 【功能】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
@Service
public class DriverServiceImpl implements IDriverService {
    @Autowired
    private DriverMapper driverMapper;

    /**
     * 查询
     *
     * @param id 主键
     * @return
     */
    @Override
    public Driver selectDriverById(Long id) {
        return driverMapper.selectDriverById(id);
    }

    /**
     * 查询
     *
     * @param driver
     * @return
     */
    @Override
    public List<Driver> selectDriverList(Driver driver) {
        return driverMapper.selectDriverList(driver);
    }

    /**
     * 新增【功能】
     *
     * @param driver 【功能】
     * @return 结果
     */
    @Override
    public int insertDriver(Driver driver) {
        driver.setCreateTime(DateUtils.getNowDate());
        return driverMapper.insertDriver(driver);
    }

    /**
     * 修改【功能】
     *
     * @param driver 【功能】
     * @return 结果
     */
    @Override
    public int updateDriver(Driver driver) {
        return driverMapper.updateDriver(driver);
    }

    /**
     * 批量删除【功能】
     *
     * @param ids 需要删除的【功能】主键
     * @return 结果
     */
    @Override
    public int deleteDriverByIds(Long[] ids) {
        return driverMapper.deleteDriverByIds(ids);
    }

    /**
     * 删除【功能】信息
     *
     * @param id 【功能】主键
     * @return 结果
     */
    @Override
    public int deleteDriverById(Long id) {
        return driverMapper.deleteDriverById(id);
    }

    @Override
    public List<Driver> sectDriverList() {
        return driverMapper.selectDriverList(null);
    }

}
