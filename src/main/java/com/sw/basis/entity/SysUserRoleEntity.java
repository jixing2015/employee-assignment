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
 * 用户角色表
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@TableName("sys_user_role")
@Data
public class SysUserRoleEntity {

    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 角色编号
     */
    private String roleCode;

    /**
     * 类型；0，用户；1，职级；2,岗位
     */
    private Integer types;

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
            this.setId(SeqUtil.nextValue(SeqUtil.ServiceSeqName.SYS_USER_ROLE));
            this.setDelFlag(CommonInfo.DelFlag.UN_DEL);
            this.setCreateTime(new Date());
            this.setCreateBy(LocalUserUtil.getCurrentUser() != null ? LocalUserUtil.getCurrentUser().getCode() : null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
