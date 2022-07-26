package com.sw.basis.controller;


import com.sw.basis.dto.request.ProjectInformationDTO;
import com.sw.basis.dto.request.ProjectModifyDTO;
import com.sw.basis.service.ProjectService;
import com.sw.basis.utils.Responses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 项目表 前端控制器
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Api(tags = "项目表")
@RequestMapping("/project")
@RestController
public class ProjectController {

    @Resource
    ProjectService projectService;

    final static String ADD = "项目表_新增";
//    @Log(desc = ADD, type = Log.LOG_TYPE.ADD)
    @ApiOperation(value = ADD)
    @PostMapping(value = "/add")
    public Responses<String> add(@RequestBody ProjectModifyDTO dto){
        return projectService.add(dto);
    }


    final static String ACCEPT = "接受信天游项目信息";
//    @Log(desc = ACCEPT, type = Log.LOG_TYPE.ADD)
    @ApiOperation(value = ACCEPT)
    @PostMapping("/accept")
    public Responses<String> accept(@RequestBody ProjectInformationDTO projectInformationDTO) {
        return projectService.accept(projectInformationDTO);
    }


}

