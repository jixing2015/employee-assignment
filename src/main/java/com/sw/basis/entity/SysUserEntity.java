package com.sw.basis.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sw.basis.utils.LocalUserUtil;
import com.sw.basis.utils.SeqUtil;
import com.sw.basis.utils.restful.CommonInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class SysUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 用户编号
     */
    private String code;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 板块编号
     */
    private String plageCode;

    /**
     * 板块名称
     */
    private String plageName;

    /**
     * 区域编号
     */
    private String areaCode;

    /**
     * 区域名称
     */
    private String areaName;

    /**
     * 部门编号
     */
    private String deptCode;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 条线编号
     */
    private String lineCode;

    /**
     * 条线名称
     */
    private String lineName;

    /**
     * 职级编号
     */
    private String levelCode;

    /**
     * 职级名称
     */
    private String levelName;

    /**
     * 执业资格
     */
    private String register;

    /**
     * 专业编号
     */
    private String expertType;

    /**
     * 状态
     */
    private Integer state;

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

    /**
     * 新增前初始化
     **/
    public void preInsert() {
        String sysUserStr = SeqUtil.ServiceSeqName.SYS_USER;
        Integer id = SeqUtil.nextValue(sysUserStr);
        try {
            this.setId(id);
            this.setDelFlag(CommonInfo.DelFlag.UN_DEL);
            this.setCreateTime(new Date());
            this.setCreateBy(LocalUserUtil.getCurrentUser() != null ? LocalUserUtil.getCurrentUser().getCode() : null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
