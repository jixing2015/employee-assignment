package com.sw.basis.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 流程表
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("flow")
public class FlowEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 上一级id
     */
    private Integer pid;

    /**
     * UUID
     */
    private String uuid;

    /**
     * 类型;0人员派遣；1借调；
     */
    private Integer flowType;

    /**
     * 操作名称
     */
    private String actionName;

    /**
     * 发起人编号
     */
    private String applyUserCode;

    /**
     * 发起人名称
     */
    private String applyUserName;

    /**
     * 办理人编号
     */
    private String handlerCode;

    /**
     * 办理人名称
     */
    private String handlerName;

    /**
     * 状态;Y，已处理；N，未处理;
     */
    private String state;

    /**
     * 审批意见
     */
    private String comments;

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
