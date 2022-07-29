package com.sw.basis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


/**
 * 项目组成员信息
 *
 * @author jixing2000
 * @since 2022-07-29
 */
@Data
@TableName("project_members")
public class ProjectMembersEntity {

    /**
     * 主键
     **/
    private Integer id;
    /**
     * 单据编号
     **/
    private String pmresResid;
    /**
     * 员工工号
     **/
    private String pmresRescode;
    /**
     * 员工姓名
     **/
    private String pmresName;
    /**
     * 部门id
     **/
    private String pmresEntity;
    /**
     * 部门编号
     **/
    private String asorgOrgcode;
    /**
     * 部门名称
     **/
    private String asorgOrgname;
    /**
     * 派遣开始日期
     **/
    private Date pmprjresFromdate;
    /**
     * 派遣结束日期
     **/
    private Date pmprjresTodate;
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