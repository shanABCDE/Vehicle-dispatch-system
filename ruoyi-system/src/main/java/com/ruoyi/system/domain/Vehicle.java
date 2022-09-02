package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【功能】对象 vehicle
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
public class Vehicle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 车牌 */
    @Excel(name = "车牌")
    private String licencePlate;

    /** 车型 */
    @Excel(name = "车型")
    private String motorcycleType;

    /** 年限 */
    @Excel(name = "年限")
    private String ageLimit;

    /** 状态 */
    @Excel(name = "状态")
    private Long state;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLicencePlate(String licencePlate) 
    {
        this.licencePlate = licencePlate;
    }

    public String getLicencePlate() 
    {
        return licencePlate;
    }
    public void setMotorcycleType(String motorcycleType) 
    {
        this.motorcycleType = motorcycleType;
    }

    public String getMotorcycleType() 
    {
        return motorcycleType;
    }
    public void setAgeLimit(String ageLimit) 
    {
        this.ageLimit = ageLimit;
    }

    public String getAgeLimit() 
    {
        return ageLimit;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("licencePlate", getLicencePlate())
            .append("motorcycleType", getMotorcycleType())
            .append("ageLimit", getAgeLimit())
            .append("state", getState())
            .append("createTime", getCreateTime())
            .toString();
    }
}
