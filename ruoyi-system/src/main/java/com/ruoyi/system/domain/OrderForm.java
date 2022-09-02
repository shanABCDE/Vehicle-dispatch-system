package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【功能】对象 order_form
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
public class OrderForm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 客户 */
    @Excel(name = "客户")
    private Long clienteleId;

    /** 交易内容 */
    @Excel(name = "交易内容")
    private String content;

    /** 驾驶员 */
    @Excel(name = "驾驶员")
    private Long driverId;

    /** 车辆 */
    @Excel(name = "车辆")
    private Long vehicleId;

    /** 出发地址 */
    @Excel(name = "出发地址")
    private String depart;

    /** 到达地址 */
    @Excel(name = "到达地址")
    private String arrive;

    /** 交易金额 */
    @Excel(name = "交易金额")
    private Long sum;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setClienteleId(Long clienteleId) 
    {
        this.clienteleId = clienteleId;
    }

    public Long getClienteleId() 
    {
        return clienteleId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setDriverId(Long driverId) 
    {
        this.driverId = driverId;
    }

    public Long getDriverId() 
    {
        return driverId;
    }
    public void setVehicleId(Long vehicleId) 
    {
        this.vehicleId = vehicleId;
    }

    public Long getVehicleId() 
    {
        return vehicleId;
    }
    public void setDepart(String depart) 
    {
        this.depart = depart;
    }

    public String getDepart() 
    {
        return depart;
    }
    public void setArrive(String arrive) 
    {
        this.arrive = arrive;
    }

    public String getArrive() 
    {
        return arrive;
    }
    public void setSum(Long sum) 
    {
        this.sum = sum;
    }

    public Long getSum() 
    {
        return sum;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("clienteleId", getClienteleId())
            .append("content", getContent())
            .append("driverId", getDriverId())
            .append("vehicleId", getVehicleId())
            .append("depart", getDepart())
            .append("arrive", getArrive())
            .append("sum", getSum())
            .append("state", getState())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .toString();
    }
}
