package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.ValidateVO;
import com.sw.basis.dto.response.ProjectValidateDTO;
import com.sw.basis.dto.response.UserValidateDTO;
import com.sw.basis.entity.FlowEntity;
import com.sw.basis.entity.SysDeptEntity;
import com.sw.basis.entity.SysSettingsEntity;
import com.sw.basis.mapper.FlowMapper;
import com.sw.basis.service.FlowService;
import com.sw.basis.service.SysDeptService;
import com.sw.basis.service.SysSettingsService;
import com.sw.basis.utils.DateUtils;
import com.sw.basis.utils.Responses;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 流程表 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Service
public class FlowServiceImpl extends ServiceImpl<FlowMapper, FlowEntity> implements FlowService {

    @Resource
    SysSettingsService sysSettingsService;
    @Resource
    SysDeptService sysDeptService;
    /**
     * 校验
     * @param vo 校验所需条件
     *
     * @return com.sw.basis.utils.Responses<java.lang.String>
     **/
    @Override
    public Responses<String> validate(ValidateVO vo) {
        Date nowDate = new Date();
        Integer startTimeInt = DateUtils.getDiffDays(vo.getStartTime(),nowDate);
        //1、派遣开始时间大于当前日期
        if(startTimeInt < 0){
            // 当前日期后同项目有无派遣记录
            Boolean hadDispatchRecord = this.hadDispatchRecord(nowDate,vo.getProjectList());
            //2、有派遣记录
            if(hadDispatchRecord){
                // 取消所选员工所在项目当前日期后的派遣记录
                this.cancelAfterDispatch(vo);
                // 项目派工成本与预计时间成本比率是否超过用户设定值
                // 所选人员、项目的总共的派工成本
                Integer totalDispatchCost = 0;
                for(UserValidateDTO userValidateDTO : vo.getUserList()){
                    totalDispatchCost += userValidateDTO.getDispatchCost();
                }
                for(ProjectValidateDTO projectValidateDTO : vo.getProjectList()){
                    //查询项目所属板块
                    SysDeptEntity sysDeptEntity = sysDeptService.getPlageByDeptCode(projectValidateDTO.getDeptCode());
                    SysSettingsEntity sysSettingsEntity = sysSettingsService.detail(sysDeptEntity.getPlageCode());
                    //项目派工成本与预计时间成本比率
                    Integer nowDispatchEstimatePercent = (totalDispatchCost / projectValidateDTO.getEstimatedTimeCost())*100;
                    if(sysSettingsEntity != null){
                        //4、超过：项目派工成本与预计时间成本比率超过用户设定值
                        if( sysSettingsEntity.getDispatchEstimatePercent() > nowDispatchEstimatePercent ){

                        }
                        //5、未超过：项目派工成本与预计时间成本比率未超过用户设定值
                        else{

                        }
                    }

                }
            }
            //3、无派遣记录
            else{

            }
        }
        // 派遣结束时间小于等于当前日期
        Integer endTimeInt = DateUtils.getDiffDays(nowDate,vo.getEndTime());
        if(endTimeInt < 0){

        }
        return Responses.success();
    }

    /**
     * 此日期后是否有此项目的派遣记录
     * @param date 日期
     * @param projectValidateDTOList 项目集合
     *
     * @return true 表示有；false 表示没有
     **/
    private Boolean hadDispatchRecord(Date date, List<ProjectValidateDTO> projectValidateDTOList){
        Boolean flag = false;

        return flag;
    }

    /**
     * 取消所选员工所在项目当前日期后的派遣记录
     * @param vo 表单
     *
     **/
    private void cancelAfterDispatch(ValidateVO vo){

    }

}
