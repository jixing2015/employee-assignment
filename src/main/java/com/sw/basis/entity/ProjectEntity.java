package com.sw.basis.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sw.basis.utils.LocalUserUtil;
import com.sw.basis.utils.SeqUtil;
import com.sw.basis.utils.restful.CommonInfo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 项目表
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Data
@TableName("project")
public class ProjectEntity {

    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 项目编号
     */
    private String projectCode;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 部门编号
     */
    private String deptCode;

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * 委托人
     */
    private String client;

    /**
     * 被审计单位
     */
    private String auditee;

    /**
     * 立项日期
     */
    private Date approvalDate;

    /**
     * 风险分类
     */
    private Integer riskCategory;

    /**
     * 板块
     */
    private Integer pmprojectBusinesstype;

    /**
     * 项目类型
     */
    private Integer pmprojectPrjtmpid;

    /**
     * 委托人名称
     */
    private String pmprojectCustomer;

    /**
     * 被审计单位名称
     */
    private String pmprojectExaminate;

    /**
     * 预计时间成本（万元）
     */
    private BigDecimal pmbusutakeTimecost;

    /**
     * 项目状态
     */
    private Integer pmprojectStatus;

    /**
     * 负责经理
     */
    private String pmprojectManager;

    /**
     * 负责经理2
     */
    private String pmprojectManager2;

    /**
     * 负责经理2状态
     */
    private String pmprojectManager2status;

    /**
     * 现场负责人
     */
    private String pmprojectCedperson;

    /**
     * 负责合伙人
     */
    private String pmprojectPartner;

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
        try {
            this.setId(SeqUtil.nextValue(SeqUtil.ServiceSeqName.PROJECT));
            this.setDelFlag(CommonInfo.DelFlag.UN_DEL);
            this.setCreateTime(new Date());
            this.setCreateBy(LocalUserUtil.getCurrentUser() != null ? LocalUserUtil.getCurrentUser().getCode() : null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
