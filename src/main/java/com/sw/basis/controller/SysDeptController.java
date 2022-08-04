package com.sw.basis.controller;


import com.sw.basis.annotation.Log;
import com.sw.basis.dto.query.DeptQuery;
import com.sw.basis.dto.request.DepartmentInformationDTO;
import com.sw.basis.dto.response.SysDictDTO;
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
import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author donglinmo
 * @since 2022-07-21
 */
@Api(tags = "部门管理")
@RestController
@RequestMapping("/sysDept")
public class SysDeptController {

    @Resource
    SysDeptService sysDeptService;

    private final static String ADD = "接受信天游部门信息";
    @ApiOperation(value = ADD)
    @Log(desc = ADD, type = Log.LOG_TYPE.ADD)
    @PostMapping("/departmentInformation")
    public Responses<String> departmentInformation (@RequestBody @Valid DepartmentInformationDTO departmentInformationDTO) {
        if (departmentInformationDTO == null) {
            return Responses.error("信天游部门信息不能为空");
        }
        return sysDeptService.insert(departmentInformationDTO);
    }

    final String DEPT_DICT = "部门字典";
    @ApiOperation(value = DEPT_DICT)
    @Log(desc = DEPT_DICT, type = Log.LOG_TYPE.SELECT)
    @PostMapping("/deptDict")
    public Responses<List<SysDictDTO>> deptDict(@RequestBody DeptQuery deptQuery) {
        return sysDeptService.deptDict(deptQuery);
    }

    final String PLAGE_DICT = "板块字典";
    @ApiOperation(value = PLAGE_DICT)
    @Log(desc = PLAGE_DICT, type = Log.LOG_TYPE.SELECT)
    @PostMapping("/plageDict")
    public Responses<List<SysDictDTO>> plageDict() {
        return sysDeptService.plageDict();
    }

    final String AREA_DICT = "区域字典";
    @ApiOperation(value = AREA_DICT)
    @Log(desc = AREA_DICT, type = Log.LOG_TYPE.SELECT)
    @PostMapping("/areaDict")
    public Responses<List<SysDictDTO>> areaDict() {
        return sysDeptService.areaDict();
    }

    final String LINE_DICT = "业务条线字典";
    @ApiOperation(value = LINE_DICT)
    @Log(desc = LINE_DICT, type = Log.LOG_TYPE.SELECT)
    @PostMapping("/lineDict")
    public Responses<List<SysDictDTO>> lineDict() {
        return sysDeptService.lineDict();
    }
}

