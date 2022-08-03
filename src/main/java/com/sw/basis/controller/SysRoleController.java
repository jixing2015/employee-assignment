package com.sw.basis.controller;


import com.sw.basis.annotation.Log;
import com.sw.basis.dto.query.SysRolePageDTO;
import com.sw.basis.dto.request.SysRoleModifyDTO;
import com.sw.basis.dto.response.SysRoleDTO;
import com.sw.basis.service.SysRoleService;
import com.sw.basis.utils.Responses;
import com.sw.basis.utils.vo.IdVO;
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
 * 角色表 前端控制器
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Api(tags = "岗位管理")
@RequestMapping("/sysRole")
@RestController
public class SysRoleController {

    @Resource
    SysRoleService sysRoleService;

    final static String PAGE = "岗位管理_列表";
    @Log(desc = PAGE, type = Log.LOG_TYPE.SELECT)
    @ApiOperation(value = PAGE)
    @PostMapping(value = "/page")
    public Responses<List<SysRoleDTO>> page(@RequestBody SysRolePageDTO dto){
        return sysRoleService.page(dto);
    }

    final static String ADD = "岗位管理_新增";
    @Log(desc = ADD, type = Log.LOG_TYPE.ADD)
    @ApiOperation(value = ADD)
    @PostMapping(value = "/add")
    public Responses<String> add(@RequestBody SysRoleModifyDTO dto){
        return sysRoleService.add(dto);
    }

    final static String UPDATE_BY_ID = "岗位管理_根据id修改";
    @Log(desc = UPDATE_BY_ID, type = Log.LOG_TYPE.UPDATE)
    @ApiOperation(value = UPDATE_BY_ID)
    @PostMapping(value = "/updateById")
    public Responses<String> updateById(@RequestBody SysRoleModifyDTO dto){
        return sysRoleService.updateById(dto);
    }

    final static String DISABLE_SWITCH = "岗位管理_禁用";
    @Log(desc = DISABLE_SWITCH, type = Log.LOG_TYPE.UPDATE)
    @ApiOperation(value = DISABLE_SWITCH,notes = "传id、state（状态;0已启用,1已停用）")
    @PostMapping(value = "/disableSwitch")
    public Responses<String> disableSwitch(@RequestBody SysRoleModifyDTO dto){
        return sysRoleService.disableSwitch(dto);
    }

    final static String DETAIL = "岗位管理_详情";
    @Log(desc = DETAIL, type = Log.LOG_TYPE.SELECT)
    @ApiOperation(value = DETAIL)
    @PostMapping(value = "/detail")
    public Responses<SysRoleDTO> detail(@RequestBody IdVO vo){
        return sysRoleService.detail(vo.getId());
    }
}

