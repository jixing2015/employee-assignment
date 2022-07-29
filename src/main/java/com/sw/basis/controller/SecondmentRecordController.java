package com.sw.basis.controller;


import com.sw.basis.annotation.Log;
import com.sw.basis.dto.response.SecondmentRecordDTO;
import com.sw.basis.entity.SecondmentRecordEntity;
import com.sw.basis.service.SecondmentRecordService;
import com.sw.basis.utils.Responses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 借调记录 前端控制器
 * </p>
 *
 * @author donglinmo
 * @since 2022-07-26
 */
@Api(tags = "借调记录信息")
@RestController
@RequestMapping("/secondmentRecord")
public class SecondmentRecordController {

    @Resource
    SecondmentRecordService secondmentRecordService;


    private static final String SELECT = "查询借调记录";
    @Log(desc = SELECT, type = Log.LOG_TYPE.SELECT)
    @ApiOperation(value = "借调记录查询")
    @PostMapping("/secondmentInquiry")
    public Responses<List<SecondmentRecordDTO>> secondmentInquiry () {
        List<SecondmentRecordDTO> secondmentRecordEntityList = secondmentRecordService.selectSecondmentRecord();
        return Responses.success(secondmentRecordEntityList);
    }

}

