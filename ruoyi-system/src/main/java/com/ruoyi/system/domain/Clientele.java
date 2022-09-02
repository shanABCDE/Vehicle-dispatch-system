package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【功能】对象 clientele
 *
 * @author ruoyi
 * @date 2022-05-24
 */
public class Clientele extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 密码 */
    @Excel(name = "密码")
    private String cipher;

    /** 性别 */
    @Excel(name = "性别")
    private Long gender;

    /** 账户余额 */
    @Excel(name = "账户余额")
    private Long balance;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String relation;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setCipher(String cipher)
    {
        this.cipher = cipher;
    }

    public String getCipher()
    {
        return cipher;
    }
    public void setGender(Long gender)
    {
        this.gender = gender;
    }

    public Long getGender()
    {
        return gender;
    }
    public void setBalance(Long balance)
    {
        this.balance = balance;
    }

    public Long getBalance()
    {
        return balance;
    }
    public void setRelation(String relation)
    {
        this.relation = relation;
    }

    public String getRelation()
    {
        return relation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("cipher", getCipher())
                .append("gender", getGender())
                .append("balance", getBalance())
                .append("relation", getRelation())
                .append("createTime", getCreateTime())
                .toString();
    }
}
