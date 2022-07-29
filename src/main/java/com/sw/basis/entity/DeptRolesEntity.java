package com.sw.basis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


/**
 * 部门角色
 *
 * @author jixing2000
 * @since 2022-07-29
 */
@Data
@TableName("dept_roles")
public class DeptRolesEntity {

    /**
     * 主键
     **/
    private Integer id;
    /**
     * 角色（部门负责经理，部门秘书）
     **/
    private String asorgroleName;
    /**
     * 员工
     **/
    private String asorgroleempEmpid;
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