package com.sw.basis.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sw.basis.annotation.Log;
import com.sw.basis.dto.query.SysUserQuery;
import com.sw.basis.dto.request.SysUserModifyDTO;
import com.sw.basis.dto.request.UserInformationDTO;
import com.sw.basis.dto.response.SysDictDTO;
import com.sw.basis.dto.response.SysUserDTO;
import com.sw.basis.service.DeptRolesService;
import com.sw.basis.service.SysUserService;
import com.sw.basis.utils.Responses;
import com.sw.basis.utils.vo.CodeListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Api(tags = "用户管理")
@RequestMapping("/sysUser")
@RestController
public class SysUserController {

    @Resource
    SysUserService sysUserService;
    @Resource
    DeptRolesService deptRolesService;

    final String PAGE = "用户_分页列表";
    @Log(desc = PAGE, type = Log.LOG_TYPE.SELECT)
    @ApiOperation(value = PAGE)
    @PostMapping("/page")
    public Responses<IPage<SysUserDTO>> page(@RequestBody SysUserQuery query) {
        return Responses.success(sysUserService.page(query));
    }

    final String GET_USER_LIST = "用户列表";
    @ApiOperation(value = GET_USER_LIST)
    @Log(desc = GET_USER_LIST, type = Log.LOG_TYPE.SELECT)
    @PostMapping("/getUserList")
    public Responses<List<SysUserDTO>> getUserList(@RequestBody SysUserQuery query) {
        return Responses.success(sysUserService.getUserList(query));
    }

    final String ADD = "新增";
    @ApiOperation(value = ADD)
    @Log(desc = ADD, type = Log.LOG_TYPE.ADD)
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

    final String USER_LEVEL_DICT = "用户职级字典";
    @ApiOperation(value = USER_LEVEL_DICT)
    @Log(desc = USER_LEVEL_DICT, type = Log.LOG_TYPE.SELECT)
    @PostMapping("/userLevelDict")
    public Responses<List<SysDictDTO>> userLevelDict() {
        return sysUserService.userLevelDict();
    }

    final String GET_USER_LIST_BY_LEVEL = "根据职级查询用户列表";
    @ApiOperation(value = GET_USER_LIST_BY_LEVEL,notes = "传职级编号集合")
    @Log(desc = GET_USER_LIST_BY_LEVEL, type = Log.LOG_TYPE.SELECT)
    @PostMapping("/getUserListByLevel")
    public Responses<List<SysUserDTO>> getUserListByLevel(@RequestBody CodeListVO list) {
        return sysUserService.getUserListByLevel(list.getCode());
    }

    final String DEPT_ROLES_DICT = "部门角色字典";
    @ApiOperation(value = DEPT_ROLES_DICT)
    @Log(desc = DEPT_ROLES_DICT, type = Log.LOG_TYPE.SELECT)
    @PostMapping("/deptRolesDict")
    public Responses<List<SysDictDTO>> deptRolesDict() {
        return deptRolesService.deptRolesDict();
    }

    final String GET_USER_LIST_BY_ROLE = "根据角色查询用户列表";
    @ApiOperation(value = GET_USER_LIST_BY_ROLE,notes = "传角色编号集合")
    @Log(desc = GET_USER_LIST_BY_ROLE, type = Log.LOG_TYPE.SELECT)
    @PostMapping("/getUserListByRole")
    public Responses<List<SysUserDTO>> getUserListByRole(@RequestBody CodeListVO list) {
        return sysUserService.getUserListByRole(list.getCode());
    }
}

