package com.sw.basis.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统设置
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_settings")
public class SysSettingsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 所属板块
     */
    private String plage;

    /**
     * 每人每日可派遣项目数量上限（天）
     */
    private Integer projectNumMax;

    /**
     * 每人每日可派遣工时数上限（h）
     */
    private Integer workHoursMax;

    /**
     * 最大派遣周期（天）
     */
    private Integer cycleMax;

    /**
     * 是否跨部门派遣;0否；1是；
     */
    private Integer crossDept;

    /**
     * 是否跨条线派遣;0否；1是；
     */
    private Integer crossLine;

    /**
     * 项目派工成本与预计时间成本最大比例
     */
    private Integer dispatchEstimatePercent;

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
