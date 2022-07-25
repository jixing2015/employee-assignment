package com.sw.basis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.dto.query.SysUserQuery;
import com.sw.basis.dto.request.SysUserModifyDTO;
import com.sw.basis.dto.request.UserInformationDTO;
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
}
