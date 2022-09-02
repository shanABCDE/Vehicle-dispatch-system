package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OrderFormMapper;
import com.ruoyi.system.domain.OrderForm;
import com.ruoyi.system.service.IOrderFormService;

/**
 * 【功能】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
@Service
public class OrderFormServiceImpl implements IOrderFormService 
{
    @Autowired
    private OrderFormMapper orderFormMapper;

    /**
     * 查询【功能】
     * 
     * @param id 【功能】主键
     * @return 【功能】
     */
    @Override
    public OrderForm selectOrderFormById(Long id)
    {
        return orderFormMapper.selectOrderFormById(id);
    }

    /**
     * 查询
     * 
     * @param orderForm 【功能】
     * @return 【功能】
     */
    @Override
    public List<OrderForm> selectOrderFormList(OrderForm orderForm)
    {
        return orderFormMapper.selectOrderFormList(orderForm);
    }

    /**
     * 新增【功能】
     * 
     * @param orderForm 【功能】
     * @return 结果
     */
    @Override
    public int insertOrderForm(OrderForm orderForm)
    {
        orderForm.setCreateTime(DateUtils.getNowDate());
        return orderFormMapper.insertOrderForm(orderForm);
    }

    /**
     * 修改【功能】
     * 
     * @param orderForm 【功能】
     * @return 结果
     */
    @Override
    public int updateOrderForm(OrderForm orderForm)
    {
        return orderFormMapper.updateOrderForm(orderForm);
    }

    /**
     * 批量删除【功能】
     * 
     * @param ids 需要删除的【功能】主键
     * @return 结果
     */
    @Override
    public int deleteOrderFormByIds(Long[] ids)
    {
        return orderFormMapper.deleteOrderFormByIds(ids);
    }

    /**
     * 删除【功能】信息
     * 
     * @param id 【功能】主键
     * @return 结果
     */
    @Override
    public int deleteOrderFormById(Long id)
    {
        return orderFormMapper.deleteOrderFormById(id);
    }
}
