package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Clientele;

/**
 * 【功能】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-22
 */
public interface ClienteleMapper 
{
    /**
     * 查询【功能】
     * 
     * @param id 【功能】主键
     * @return 【功能】
     */
    public Clientele selectClienteleById(Long id);

    /**
     * 查询
     * 
     * @param clientele 【功能】
     * @return 【功能】集合
     */
    public List<Clientele> selectClienteleList(Clientele clientele);

    /**
     * 新增【功能】
     * 
     * @param clientele 【功能】
     * @return 结果
     */
    public int insertClientele(Clientele clientele);

    /**
     * 修改【功能】
     * 
     * @param clientele 【功能】
     * @return 结果
     */
    public int updateClientele(Clientele clientele);

    /**
     * 删除【功能】
     * 
     * @param id 【功能】主键
     * @return 结果
     */
    public int deleteClienteleById(Long id);

    /**
     * 批量删除【功能】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClienteleByIds(Long[] ids);
}
