package com.sw.basis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 职级费率
 *
 * @author jixing2000
 * @since 2022-07-29
 */
@Data
@TableName("rank_rate")
public class RankRateEntity {

    /**
     * 主键
     **/
    private Integer id;
    /**
     * 类别（职级id）
     **/
    private String pmcatehCateid;
    /**
     * 描述(职级名称)
     **/
    private String pmcatehCatename;
    /**
     * 单位成本
     **/
    private BigDecimal pmcatehPayrate;
    /**
     * 内部调用基本费率
     **/
    private BigDecimal pmcatehBillrate;
    /**
     * 内部忙季费率
     **/
    private BigDecimal pmcatehUnitprice;
    /**
     * 创建人
     **/
    private String createBy;
    /**
     * 创建时间
     **/
    private Date createTime;
    /**
     * 更新人
     **/
    private String updateBy;
    /**
     * 更新时间
     **/
    private Date updateTime;
    /**
     * 是否删除;0表示未删除，1表示删除
     **/
    private Integer delFlag;

}