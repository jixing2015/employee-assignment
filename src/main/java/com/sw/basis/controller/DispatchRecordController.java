package com.sw.basis.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sw.basis.dto.query.personnelDimensionPageDTO;
import com.sw.basis.dto.query.projectDimensionPageDTO;
import com.sw.basis.dto.response.DispatchRecordDTO;
import com.sw.basis.service.DispatchRecordService;
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
 * 派遣记录表 前端控制器
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Api(tags = "派遣管理")
@RequestMapping("/dispatchRecord")
@RestController
public class DispatchRecordController {

    @Resource
    DispatchRecordService dispatchRecordService;

    final static String PAGE_BY_PERSONNEL_DIMENSION = "项目派遣-人员维度-分页列表";
//    @Log(desc = PAGE_BY_PERSONNEL_DIMENSION, type = Log.LOG_TYPE.SELECT)
    @ApiOperation(value = PAGE_BY_PERSONNEL_DIMENSION)
    @PostMapping(value = "/pageByPersonnelDimension")
    public Responses<IPage<DispatchRecordDTO>> pageByPersonnelDimension(@RequestBody personnelDimensionPageDTO dto){
        return dispatchRecordService.pageByPersonnelDimension(dto);
    }

    final static String PAGE_BY_PROJECT_DIMENSION = "项目派遣-人员维度-分页列表";
//    @Log(desc = PAGE_BY_PROJECT_DIMENSION, type = Log.LOG_TYPE.SELECT)
    @ApiOperation(value = PAGE_BY_PROJECT_DIMENSION)
    @PostMapping(value = "/pageByProjectDimension")
    public Responses<IPage<DispatchRecordDTO>> pageByProjectDimension(@RequestBody projectDimensionPageDTO dto){
        return dispatchRecordService.pageByProjectDimension(dto);
    }
}

