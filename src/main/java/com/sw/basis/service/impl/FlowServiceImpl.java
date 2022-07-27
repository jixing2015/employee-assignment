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
            Boolean hadDispatchRecord = this.hadDispatchRecord(null,null,vo,0);
            //2、有派遣记录
            if(hadDispatchRecord){
                // 取消所选员工所在项目当前日期后的派遣记录
                this.cancelAfterDispatch(vo.getStartTime(),vo.getEndTime(),vo);
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
     * 是否有此项目的派遣记录
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param vo 校验所需条件
     * @param type 0表示当前日期后,startTime、endTime传null；1表示指定时间段内
     * @return true 有；false 没有
     **/
    private Boolean hadDispatchRecord(Date startTime,Date endTime, ValidateVO vo,Integer type){
        Boolean flag = false;

        return flag;
    }

    /**
     * 取消该员工当前项目下指定区间派工记录（若有）
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param vo 校验所需条件
     */
    private void cancelAfterDispatch(Date startTime,Date endTime,ValidateVO vo){

    }

    /**
     * 项目派工成本与预计时间成本比率是否超过用户设定值
     * @param vo 校验所需条件
     * @param type 0表示当前日期后,不用传startTime、endTime；1表示指定时间段内
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return true 超过；false 未超过
     **/
    private Boolean dispatchEstimatePercentOverstep(ValidateVO vo,Integer type,Date startTime,Date endTime){
        Boolean flag = false;
        // 项目派工成本(减掉所选员工所在项目当前日期后的派遣记录后在加上选择的派遣时间段的此员工成本)

        return flag;
    }

    /**
     * 是否有已填报工时
     * @param vo 校验所需条件
     *
     * @return true 有；false 没有
     **/
    private Boolean hadHoursFilled(ValidateVO vo){
        Boolean flag = false;

        return flag;
    }

    /**
     * 是否被借调人员
     * @param userCode 用户编号
     * @param projectCode 项目编号
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return true 是；false 否
     */
    private Boolean isSecondedPersonnel(String userCode,String projectCode,Date startTime,Date endTime){
        Boolean flag = false;

        return flag;
    }

    /**
     * 是否符合人员借调批量设置
     * @param userCode
     * @param projectCode
     *
     * @return true 符合；false 不符合
     **/
    private Boolean accordSecondedPersonnelBatchSetting(String userCode,String projectCode){
        Boolean flag = false;

        return flag;
    }

    /**
     * 项目与被借调项目派遣时间是否一致
     * @param cunrrentPro 项目
     *
     * @return true 一致；false 不一致
     **/
    private Boolean currentProjectDateCompareSecondedDate(ProjectValidateDTO cunrrentPro){
        Boolean flag = false;

        return flag;
    }

    /**
     * 是否人才基地员工
     * @param userCode 用户编号
     *
     * @return true 是；false 否
     **/
    private Boolean isTalentBaseEmployee(String userCode){
        Boolean flag = false;

        return flag;
    }

    /**
     * 人才基地的员工与项目所属部门在同一部门 且 与项目经理在一个人才基地
     * @param userValidateDTO 用户信息
     * @param projectValidateDTO 项目信息
     *
     * @return true 是；false 否
     **/
    private Boolean sameBaseAndSameDepartment(UserValidateDTO userValidateDTO,ProjectValidateDTO projectValidateDTO){
        Boolean flag = false;
        //1、人才基地的员工与项目所属部门在同一部门

        //2、人才基地的员工与项目经理在一个人才基地
        return flag;
    }

    /**
     * 是否跨部门/条线
     * @param userValidateDTO 用户信息
     * @param projectValidateDTO 项目信息
     *
     * @return true 是；false 否
     **/
    private Boolean crossDepartmentOrLine(UserValidateDTO userValidateDTO,ProjectValidateDTO projectValidateDTO){
        Boolean flag = false;

        return flag;
    }

    /**
     * 跨条线功能是否打开
     * @param plage 板块
     *
     * @return true 是；false 否
     **/
    private Boolean isCrossLineOpen(String plage){
        Boolean flag = false;

        return flag;
    }

    /**
     * 是否有全体休假
     * @param startTime 开始时间
     * @param endTime 结束时间
     *
     * @return true 有；false 无
     **/
    private Boolean allHaveHoliday(Date startTime,Date endTime){
        Boolean flag = false;

        return flag;
    }

    /**
     * 是否需要签署项目独立性
     * @param projectValidateDTO 项目信息
     *
     * @return true 需要；false 不需要
     **/
    private Boolean signProjectIndependence(ProjectValidateDTO projectValidateDTO){
        Boolean flag = false;

        return flag;
    }
}
