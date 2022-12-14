package com.sw.basis.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sw.basis.utils.LocalUserUtil;
import com.sw.basis.utils.SeqUtil;
import com.sw.basis.utils.restful.CommonInfo;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 角色表（岗位）
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Data
@TableName("sys_role")
public class SysRoleEntity {

    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 类型：0，普通角色；1,部门角色；2，岗位角色
     */
    private Integer roleType;

    /**
     * 角色编号
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建人名称
     */
    private String createName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新人名称
     */
    private String updateName;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 状态;0已启用,1已停用
     */
    private Integer state;

    /**
     * 是否删除;0表示未删除，1表示删除
     */
    private Integer delFlag;

    /**
     * 新增前初始化
     **/
    public void preInsert() {
        try {
            this.setId(SeqUtil.nextValue(SeqUtil.ServiceSeqName.SYS_ROLE));
            this.setDelFlag(CommonInfo.DelFlag.UN_DEL);
            this.setCreateTime(new Date());
            this.setCreateBy(LocalUserUtil.getCurrentUser() != null ? LocalUserUtil.getCurrentUser().getCode() : null);
            this.setCreateName(LocalUserUtil.getCurrentUser() != null ? LocalUserUtil.getCurrentUser().getName() : null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
