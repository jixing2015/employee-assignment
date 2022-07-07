package com.sw.basis.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 借调需求
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("secondment_demand")
public class SecondmentDemandEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 借调记录id
     */
    private Integer secondmentId;

    /**
     * 职级编号
     */
    private String levelCode;

    /**
     * 专业编号
     */
    private String expertType;

    /**
     * 执业资格
     */
    private String register;

    /**
     * 工作年限
     */
    private Integer workYears;

    /**
     * 项目所需人数
     */
    private Integer needPeoples;

    /**
     * 已到位人数
     */
    private Integer actuallyPeoples;

    /**
     * 需借调人数
     */
    private Integer secondmentPeoples;

    /**
     * 开始日期
     */
    private Date startTime;

    /**
     * 结束日期
     */
    private Date endTime;

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
