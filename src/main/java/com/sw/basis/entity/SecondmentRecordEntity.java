package com.sw.basis.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 借调记录
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("secondment_record")
public class SecondmentRecordEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 借调编号
     */
    private String secondmentCode;

    /**
     * 申请部门
     */
    private String deptCode;

    /**
     * 项目编号
     */
    private String projectCode;

    /**
     * 执业地点
     */
    private String address;

    /**
     * 借调协调人
     */
    private String coordinator;

    /**
     * 结算方式
     */
    private String settlement;

    /**
     * 其他要求
     */
    private String others;

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
