package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.OrderForm;

/**
 * 【功能】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
public interface OrderFormMapper 
{
    /**
     * 查询【功能】
     * 
     * @param id 【功能】主键
     * @return 【功能】
     */
    public OrderForm selectOrderFormById(Long id);

    /**
     * 查询
     * 
     * @param orderForm 【功能】
     * @return 【功能】集合
     */
    public List<OrderForm> selectOrderFormList(OrderForm orderForm);

    /**
     * 新增【功能】
     * 
     * @param orderForm 【功能】
     * @return 结果
     */
    public int insertOrderForm(OrderForm orderForm);

    /**
     * 修改【功能】
     * 
     * @param orderForm 【功能】
     * @return 结果
     */
    public int updateOrderForm(OrderForm orderForm);

    /**
     * 删除【功能】
     * 
     * @param id 【功能】主键
     * @return 结果
     */
    public int deleteOrderFormById(Long id);

    /**
     * 批量删除【功能】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrderFormByIds(Long[] ids);
}
