package com.sw.basis.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 派遣记录表
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Data
@TableName("dispatch_record")
public class DispatchRecordEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 派遣编号
     */
    private String dispatchCode;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 项目编号
     */
    private String projectCode;

    /**
     * 派遣开始时间
     */
    private Date startTime;

    /**
     * 派遣结束时间
     */
    private Date endTime;

    /**
     * 每日派遣小时数
     */
    private Integer hoursPerDay;

    /**
     * 执业地点
     */
    private String address;

    /**
     * 结算方式;0分成；1人才基地；
     */
    private Integer settlement;

    /**
     * 派工成本
     */
    private BigDecimal dispatchCost;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除;0表示未删除，1表示删除
     */
    private Integer delFlag;


}
