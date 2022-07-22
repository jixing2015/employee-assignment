package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.ValidateVO;
import com.sw.basis.dto.request.ProjectModifyDTO;
import com.sw.basis.entity.FlowEntity;
import com.sw.basis.mapper.FlowMapper;
import com.sw.basis.service.FlowService;
import com.sw.basis.utils.DateUtils;
import com.sw.basis.utils.Responses;
import org.springframework.stereotype.Service;

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

    /**
     * 校验
     * @param vo 校验所需条件
     *
     * @return com.sw.basis.utils.Responses<java.lang.String>
     **/
    @Override
    public Responses<String> validate(ValidateVO vo) {
        Date nowDate = new Date();
        //1-1 派遣开始时间大于当前日期
        Integer startTimeInt = DateUtils.getDiffDays(vo.getStartTime(),nowDate);
        if(startTimeInt < 0){
            //当前日期后同项目有无派遣记录
            Boolean hadDispatchRecord = this.hadDispatchRecord(nowDate,vo.getProjectList());
            //1-1-1 有派遣记录
            if(hadDispatchRecord){

            }
            //1-1-2 无派遣记录 todo
            else{

            }
        }
        //2-1 派遣结束时间小于等于当前日期
        Integer endTimeInt = DateUtils.getDiffDays(nowDate,vo.getEndTime());
        if(endTimeInt < 0){

        }
        return Responses.success();
    }

    /**
     * 此日期后是否有此项目的派遣记录
     * @param date 日期
     * @param projectModifyDTOList 项目集合
     *
     * @return true 表示有；false 表示没有
     **/
    private Boolean hadDispatchRecord(Date date, List<ProjectModifyDTO> projectModifyDTOList){
        Boolean flag = false;

        return flag;
    }

}
