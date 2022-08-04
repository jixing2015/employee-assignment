package com.sw.basis.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.sw.basis.entity.DeptRolesEntity;
import com.sw.basis.entity.SysUserEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

    @Select("select * from sys_user su where code in(select dr.asorgroleemp_empid code from dept_roles dr ${ew.customSqlSegment} )")
    List<SysUserEntity> getUserListByDeptRole(@Param(Constants.WRAPPER) Wrapper<DeptRolesEntity> wrapper);
}
