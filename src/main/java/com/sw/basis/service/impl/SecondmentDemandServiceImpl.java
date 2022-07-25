package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.request.SecondmentApplyDTO;
import com.sw.basis.entity.SecondmentDemandEntity;
import com.sw.basis.entity.SecondmentPeoplesEntity;
import com.sw.basis.entity.SecondmentRecordEntity;
import com.sw.basis.entity.SysLogEntity;
import com.sw.basis.mapper.SecondmentDemandMapper;
import com.sw.basis.service.SecondmentDemandService;
import com.sw.basis.service.SecondmentPeoplesService;
import com.sw.basis.service.SecondmentRecordService;
import com.sw.basis.service.SysLogService;
import com.sw.basis.utils.Responses;
import com.sw.basis.utils.exception.MyException;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 借调需求 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Service
@Slf4j
public class SecondmentDemandServiceImpl extends ServiceImpl<SecondmentDemandMapper, SecondmentDemandEntity> implements SecondmentDemandService {

    @Resource
    SecondmentRecordService secondmentRecordService;

    @Resource
    SecondmentPeoplesService secondmentPeoplesService;

    @Resource
    SysLogService sysLogService;


    /**
     * 获取借调需求信息
     *
     * @param secondmentDemandEntityList 借调需求入参
     * @return 借调需求信息
     **/
    @Override
    public List<SecondmentDemandEntity> getSecondmentDemandEntityList(List<SecondmentDemandEntity> secondmentDemandEntityList) {

        List<SecondmentDemandEntity> secondmentDemandEntityReturn = new ArrayList<>();
        secondmentDemandEntityList.stream().forEach(x -> {
            x.preInsert();
            secondmentDemandEntityReturn.add(x);
        });
        return secondmentDemandEntityReturn;
    }


    /**
     * 借调申请-新增借调信息
     *
     * @param secondmentRecordEntity 借调记录表信息
     * @param secondmentDemandEntityList 借调需求表信息
     * @param secondmentPeoplesEntityList 借调人员表信息
     * @param sysLogEntity 日志表信息
     * @return 插入表中后的结果
     **/
    @Override
    @Transactional
    public Responses getResponses(SecondmentRecordEntity secondmentRecordEntity, List<SecondmentDemandEntity> secondmentDemandEntityList, List<SecondmentPeoplesEntity> secondmentPeoplesEntityList, SysLogEntity sysLogEntity) {

        Responses responses;

        boolean bolDemand = false;
        boolean bolRecord = false;
        boolean bolPeoples = false;
        boolean bolSysLog = false;
        try {
            //向借调记录表中添加信息
            bolRecord = secondmentRecordService.save(secondmentRecordEntity);
            //向借调需求表中添加数据
            bolDemand = this.saveBatch(secondmentDemandEntityList);
            //向借调人员表中添加数据
            bolPeoples = secondmentPeoplesService.saveBatch(secondmentPeoplesEntityList);
            //向用户日志表中添加数据
            bolSysLog = sysLogService.save(sysLogEntity);
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("增加数据到数据库发生异常",e.getMessage());
            }
            //将异常原因返回前台
            responses = Responses.error("增加数据到数据库发生异常=" + e.getMessage());
            return responses;
        }

        if (bolDemand && bolRecord && bolPeoples && bolSysLog) {
            //返回成功结果
            responses = Responses.success();
        } else {
            try {
                //抛出异常，数据回滚
                throw new MyException("插入数据库失败");
            } catch (MyException e) {
                if (log.isErrorEnabled()) {
                    log.error("增加数据到数据库发生异常",e.getMessage());
                }
                //将异常原因返回前台
                responses = Responses.error(e.getMessage());
            }
        }

        return responses;
    }



    /**
     * 获取借调记录信息
     *
     * @param secondmentApplyDTO 新建借调申请入参
     * @return 借调记录信息
     **/
    @Override
    public SecondmentRecordEntity getSecondmentRecordEntity(SecondmentApplyDTO secondmentApplyDTO) {
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
