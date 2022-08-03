package com.sw.basis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.dto.api.UserDTO;
import com.sw.basis.dto.query.SysUserQuery;
import com.sw.basis.dto.request.SysUserModifyDTO;
import com.sw.basis.dto.request.UserInformationDTO;
import com.sw.basis.dto.response.SysDictDTO;
import com.sw.basis.dto.response.SysUserDTO;
import com.sw.basis.entity.SysUserEntity;
import com.sw.basis.utils.Responses;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 用户_分页列表
     * @param query 查询条件
     *
     * @return java.util.List<com.sw.basis.dto.response.SysUserDTO>
     **/
    IPage<SysUserDTO> page(SysUserQuery query);

    /**
     * 用户列表
     * @param query 查询条件
     *
     * @return java.util.List<com.sw.basis.dto.response.SysUserDTO>
     **/
    List<SysUserDTO> getUserList(SysUserQuery query);

    /**
     * 新增
     * @param dto 人员信息
     *
     * @return 成功/失败
     **/
    Responses<String> add(SysUserModifyDTO dto);

    /**
     * 接受信天游的用户信息
     * @param userInformationDTO 信天游的用户信息
     *
     * @return 成功/失败
     **/
    Responses<String> accept(UserInformationDTO userInformationDTO);

    /**
     * 同步员工档案
     * @param dtoList 员工档案集合
     *
     **/
    void pushUser(List<UserDTO> dtoList);

    /**
     *  用户职级字典
     *
     * @return 字典集合
     **/
    Responses<List<SysDictDTO>> userLevelDict();

    /**
     * 根据职级查询用户列表
     * @param levelCode 职级编号
     *
     * @return 用户列表
     **/
    Responses<List<SysUserDTO>> getUserListByLevel(String levelCode);

    /**
     * 根据角色查询用户列表
     * @param roleCode 角色编号
     *
     * @return 用户列表
     **/
    Responses<List<SysUserDTO>> getUserListByRole(String roleCode);
}
