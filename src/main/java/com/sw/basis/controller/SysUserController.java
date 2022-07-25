package com.sw.basis.controller;


import com.sw.basis.annotation.Log;
import com.sw.basis.dto.query.SysUserQuery;
import com.sw.basis.dto.request.SysUserModifyDTO;
import com.sw.basis.dto.request.UserInformationDTO;
import com.sw.basis.dto.response.SysUserDTO;
import com.sw.basis.service.impl.SysUserServiceImpl;
import com.sw.basis.utils.Responses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Api(tags = "用户接口")
@RequestMapping("/sysUser")
@RestController
public class SysUserController {

    @Resource
    SysUserServiceImpl sysUserService;

    final String GET_USER_LIST = "用户列表";
    @ApiOperation(value = GET_USER_LIST)
    @PostMapping("/getUserList")
    public Responses<List<SysUserDTO>> getUserList(@RequestBody SysUserQuery query) {
        return Responses.success(sysUserService.getUserList(query));
    }

    final String ADD = "新增";
    @ApiOperation(value = ADD)
    @PostMapping("/add")
    public Responses<String> add(@RequestBody SysUserModifyDTO dto) {
        return sysUserService.add(dto);
    }


    final String ACCEPT = "接受信天游的用户信息";
    @Log(desc = ACCEPT, type = Log.LOG_TYPE.ADD)
    @ApiOperation(value = ACCEPT)
    @PostMapping("/accept")
    public Responses<String> accept(@RequestBody UserInformationDTO userInformationDTO) {
        return sysUserService.accept(userInformationDTO);
    }






}

