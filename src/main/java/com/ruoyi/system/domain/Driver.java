package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 对象 driver
 * 
 * @author ruoyi

 */
public class Driver extends BaseEntity
{//版本向上兼容的
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 驾驶员 */
    @Excel(name = "驾驶员")
    private String name;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long annum;

    /** 状态 */
    @Excel(name = "状态")
    private Long state;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String relation;

    /** 驾龄 */
    @Excel(name = "驾龄")
    private Long drivingYears;

    /**  设置编号*/
    public void setId(Long id) 
    {
        this.id = id;
    }
    /** 获取编号 */
    public Long getId() 
    {
        return id;
    }
    /** 设置name */
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    /** 设置年龄 */
    public void setAnnum(Long annum)
    {
        this.annum = annum;
    }
    /** 获取年龄 */
    public Long getAnnum() 
    {
        return annum;
    }

    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }

    public void setRelation(String relation) 
    {
        this.relation = relation;
    }

    public String getRelation() 
    {
        return relation;
    }

    public void setDrivingYears(Long drivingYears) 
    {
        this.drivingYears = drivingYears;
    }

    public Long getDrivingYears() 
    {
        return drivingYears;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("annum", getAnnum())
            .append("state", getState())
            .append("relation", getRelation())
            .append("drivingYears", getDrivingYears())
            .append("createTime", getCreateTime())
            .toString();
    }
}
