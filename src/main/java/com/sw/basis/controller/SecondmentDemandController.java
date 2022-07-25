package com.sw.basis.controller;


import com.sw.basis.dto.request.SecondmentApplyDTO;
import com.sw.basis.entity.SecondmentDemandEntity;
import com.sw.basis.entity.SecondmentPeoplesEntity;
import com.sw.basis.entity.SecondmentRecordEntity;
import com.sw.basis.entity.SysLogEntity;
import com.sw.basis.service.SecondmentDemandService;
import com.sw.basis.service.SecondmentPeoplesService;
import com.sw.basis.utils.Responses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 借调需求 前端控制器
 * </p>
 *
 * @author donglinmo
 * @since 2022-07-11
 */
@Slf4j
@Api(tags = "借调申请接口")
@RestController
@RequestMapping("/SecondmentDemandController")
public class SecondmentDemandController {

    @Resource
    SecondmentDemandService scondmentDemandService;
    @Resource
    SecondmentPeoplesService secondmentPeoplesService;


    @ApiOperation("新建借调申请")
    @PostMapping("/secondmentToApply")
    public Responses secondmentToApply(@RequestBody @Validated SecondmentApplyDTO secondmentApplyDTO){

        //获取借调记录信息
        SecondmentRecordEntity secondmentRecordEntity = scondmentDemandService.getSecondmentRecordEntity(secondmentApplyDTO);
        //获取借调需求信息
        List<SecondmentDemandEntity> secondmentDemandEntityListaa = secondmentApplyDTO.getSecondmentDemandEntityList();
        List<SecondmentDemandEntity> secondmentDemandEntityList = scondmentDemandService.getSecondmentDemandEntityList(secondmentDemandEntityListaa);
        //获取借调人员信息
        List<SecondmentPeoplesEntity> secondmentPeoplesEntityList = secondmentPeoplesService.getSecondmentPeoplesEntityList(secondmentApplyDTO.getSecondmentPeoplesEntityList());
        //用户日志表
        SysLogEntity sysLogEntity = secondmentApplyDTO.getSysLogEntity();

        sysLogEntity.preInsert();
        sysLogEntity.setActionName("新建借调申请");

        Responses responses = scondmentDemandService.getResponses(secondmentRecordEntity,secondmentDemandEntityList,secondmentPeoplesEntityList,sysLogEntity);

        return responses;
    }



}

