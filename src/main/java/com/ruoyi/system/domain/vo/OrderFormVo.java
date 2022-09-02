package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【功能】对象 order_form
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
public class OrderFormVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 客户 */
    private String clienteleName;

    /** 客户电话 */
    private String clienteleRelation;

    /** 驾驶员 */
    @Excel(name = "驾驶员")
    private String driverName;
    /** 驾驶员电话 */
    @Excel(name = "驾驶员")
    private String driverRelation;
    /** 车牌 */
    @Excel(name = "车辆")
    private String vehicleLicencePlate;
    /** 车型 */
    @Excel(name = "车辆")
    private String vehicleMotorcycleType;
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




    public String getClienteleName() {
        return clienteleName;
    }

    public void setClienteleName(String clienteleName) {
        this.clienteleName = clienteleName;
    }

    public String getClienteleRelation() {
        return clienteleRelation;
    }

    public void setClienteleRelation(String clienteleRelation) {
        this.clienteleRelation = clienteleRelation;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverRelation() {
        return driverRelation;
    }

    public void setDriverRelation(String driverRelation) {
        this.driverRelation = driverRelation;
    }

    public String getVehicleLicencePlate() {
        return vehicleLicencePlate;
    }

    public void setVehicleLicencePlate(String vehicleLicencePlate) {
        this.vehicleLicencePlate = vehicleLicencePlate;
    }

    public String getVehicleMotorcycleType() {
        return vehicleMotorcycleType;
    }

    public void setVehicleMotorcycleType(String vehicleMotorcycleType) {
        this.vehicleMotorcycleType = vehicleMotorcycleType;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
        return "OrderFormVo{" +
                "id=" + id +
                ", clienteleName='" + clienteleName + '\'' +
                ", clienteleRelation='" + clienteleRelation + '\'' +
                ", driverName='" + driverName + '\'' +
                ", driverRelation='" + driverRelation + '\'' +
                ", vehicleLicencePlate='" + vehicleLicencePlate + '\'' +
                ", vehicleMotorcycleType='" + vehicleMotorcycleType + '\'' +
                ", depart='" + depart + '\'' +
                ", arrive='" + arrive + '\'' +
                ", sum=" + sum +
                ", state='" + state + '\'' +
                '}';
    }
}
