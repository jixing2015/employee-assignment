package com.sw.basis.controller;


import com.sw.basis.annotation.Log;
import com.sw.basis.dto.response.SysMenuDTO;
import com.sw.basis.service.SysMenuService;
import com.sw.basis.utils.Responses;
import com.sw.basis.utils.vo.CodeVO;
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
 * 权限表 前端控制器
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Api(tags = "权限管理")
@RequestMapping("/sysMenu")
@RestController
public class SysMenuController {

    @Resource
    SysMenuService sysMenuService;

    final static String TREE = "权限管理_树";
    @Log(desc = TREE, type = Log.LOG_TYPE.SELECT)
    @ApiOperation(value = TREE,notes = "code传角色编号，如果传空字符串默认值返回空的树")
    @PostMapping(value = "/tree")
    public Responses<List<SysMenuDTO>> tree(@RequestBody CodeVO vo){
        return sysMenuService.tree(vo.getCode());
    }

}

