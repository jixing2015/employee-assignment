package com.sw.basis.controller;


import com.sw.basis.dto.request.SecondmentApplyDTO;
import com.sw.basis.entity.SecondmentDemandEntity;
import com.sw.basis.entity.SecondmentPeoplesEntity;
import com.sw.basis.entity.SecondmentRecordEntity;
import com.sw.basis.entity.SysLogEntity;
import com.sw.basis.service.SecondmentDemandService;
import com.sw.basis.service.SecondmentPeoplesService;
import com.sw.basis.service.SecondmentRecordService;
import com.sw.basis.service.SysLogService;
import com.sw.basis.utils.exception.MyException;
import com.sw.basis.utils.restful.ResultCode;
import com.sw.basis.utils.restful.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    SecondmentRecordService secondmentRecordService;

    @Resource
    SecondmentPeoplesService secondmentPeoplesService;

    @Resource
    SysLogService sysLogService;


    @ApiOperation("新建借调申请")
    @PostMapping("/secondmentToApply")
    @Transactional
    public ResultData secondmentToApply(@RequestBody @Validated SecondmentApplyDTO secondmentApplyDTO){

        ResultData resultData;

        //获取借调记录信息
        SecondmentRecordEntity secondmentRecordEntity = this.getSecondmentRecordEntity(secondmentApplyDTO);
        //获取借调需求信息
        List<SecondmentDemandEntity> secondmentDemandEntityListaa = secondmentApplyDTO.getSecondmentDemandEntityList();
        List<SecondmentDemandEntity> secondmentDemandEntityList = scondmentDemandService.getSecondmentDemandEntityList(secondmentDemandEntityListaa);
        //获取借调人员信息
        List<SecondmentPeoplesEntity> secondmentPeoplesEntityList = secondmentPeoplesService.getSecondmentPeoplesEntityList(secondmentApplyDTO.getSecondmentPeoplesEntityList());
        //用户日志表
        SysLogEntity sysLogEntity = secondmentApplyDTO.getSysLogEntity();

        sysLogEntity.preInsert();
        sysLogEntity.setActionName("新建借调申请");

        boolean bolDemand = false;
        boolean bolRecord = false;
        boolean bolPeoples = false;
        boolean bolSysLog = false;
        try {
            //向借调记录表中添加信息
            bolRecord = secondmentRecordService.save(secondmentRecordEntity);
            //向借调需求表中添加数据
            bolDemand = scondmentDemandService.saveBatch(secondmentDemandEntityList);
            //向借调人员表中添加数据
            bolPeoples = secondmentPeoplesService.saveBatch(secondmentPeoplesEntityList);
            //向用户日志表中添加数据
            bolSysLog = sysLogService.save(sysLogEntity);
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("增加数据到数据库发生异常",e.getMessage());
            }
            //将异常原因返回前台
            resultData = new ResultData(String.valueOf(ResultCode.EXCEPTION.code),"增加数据到数据库发生异常=" + e.getMessage());
            return resultData;
        }

        if (bolDemand && bolRecord && bolPeoples && bolSysLog) {
            //返回成功结果
            resultData = new ResultData();
        } else {
            try {
                //抛出异常，数据回滚
                throw new MyException("插入数据库失败");
            } catch (MyException e) {
                if (log.isErrorEnabled()) {
                    log.error("增加数据到数据库发生异常",e.getMessage());
                }
                //将异常原因返回前台
                resultData = new ResultData(String.valueOf(ResultCode.EXCEPTION.code),e.getMessage());
            }
        }

        return resultData;
    }


    //获取借调记录信息
    private SecondmentRecordEntity getSecondmentRecordEntity(SecondmentApplyDTO secondmentApplyDTO) {

        SecondmentRecordEntity secondmentRecordEntity = new SecondmentRecordEntity();
        //借调编号，这里是新增，所以生成一个借调编号
        UUID uuid = UUID.randomUUID();
        secondmentRecordEntity.preInsert();
        secondmentRecordEntity.setSecondmentCode(String.valueOf(uuid));
        secondmentRecordEntity.setDeptCode(secondmentApplyDTO.getApplyDeptCode());
        secondmentRecordEntity.setProjectCode(secondmentApplyDTO.getProjectCode());
        secondmentRecordEntity.setAddress(secondmentApplyDTO.getAddress());
        secondmentRecordEntity.setCoordinator(secondmentApplyDTO.getCoordinator());
        secondmentRecordEntity.setSettlement(secondmentApplyDTO.getSettlement());
        secondmentRecordEntity.setOthers(secondmentApplyDTO.getOthers());

        return secondmentRecordEntity;
    }


}

