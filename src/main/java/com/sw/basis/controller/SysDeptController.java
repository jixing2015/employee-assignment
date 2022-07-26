package com.sw.basis.controller;


import com.sw.basis.dto.request.DepartmentInformationDTO;
import com.sw.basis.service.SysDeptService;
import com.sw.basis.utils.Responses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author donglinmo
 * @since 2022-07-21
 */
@Api(tags = "部门信息")
@RestController
@RequestMapping("/sysDept")
public class SysDeptController {

    @Resource
    SysDeptService sysDeptService;

    private final static String ADD = "接受信天游部门信息";

//    @Log(desc = ADD, type = Log.LOG_TYPE.ADD)
    @ApiOperation(value = ADD)
    @PostMapping("/departmentInformation")
    public Responses<String> departmentInformation (@RequestBody @Valid DepartmentInformationDTO departmentInformationDTO) {
        if (departmentInformationDTO == null) {
            return Responses.error("信天游部门信息不能为空");
        }
        return sysDeptService.insert(departmentInformationDTO);
    }

}

