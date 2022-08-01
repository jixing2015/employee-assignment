package com.sw.basis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sw.basis.dto.request.SysUserModifyDTO;
import com.sw.basis.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户角色表 Mapper 接口
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleEntity> {

    @Select("select sur.id,sur.types ,sur.create_by ,sur.create_time ,sur.update_by ,sur.update_time ,su.code,su.name ,su.dept_code ,su.dept_name ,su.level_code ,su.level_name " +
            " from sys_user_role sur left join sys_user su on sur.user_code = su.code " +
            " where sur.del_flag = 0 and su.del_flag = 0 and sur.role_code=#{roleCode}")
    List<SysUserModifyDTO> getRoleUserList(@Param("roleCode")String roleCode);
}
