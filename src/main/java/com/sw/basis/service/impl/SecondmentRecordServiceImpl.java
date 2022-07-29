package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.request.ConditionsQueryDTO;
import com.sw.basis.dto.request.SecondmentIncreasedOrModifyDTO;
import com.sw.basis.dto.response.QueryResultsDTO;
import com.sw.basis.dto.response.SecondmentRecordDTO;
import com.sw.basis.entity.QuerySecondmentRecordEntity;
import com.sw.basis.entity.SecondmentRecordEntity;
import com.sw.basis.mapper.SecondmentRecordMapper;
import com.sw.basis.service.SecondmentRecordService;
import com.sw.basis.utils.Responses;
import com.sw.basis.utils.exception.MyException;
import lombok.Data;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 借调记录 服务实现类
 * </p>
 *
 * @author donglinmo
 * @since 2022-07-26
 */
@Service
public class SecondmentRecordServiceImpl extends ServiceImpl<SecondmentRecordMapper, SecondmentRecordEntity> implements SecondmentRecordService {


    @Resource
    SecondmentRecordMapper secondmentRecordMapper;

    /**
     * 查询
     * @param
     *
     * @return List<SecondmentRecordDTO> 查询借调记录的结果集
     **/
    @Override
    public List<SecondmentRecordDTO> selectSecondmentRecord() {

        List<QuerySecondmentRecordEntity>  querySecondmentRecordEntityList = secondmentRecordMapper.selectSecondmentRecord();
        List<SecondmentRecordDTO> secondmentRecordDTOList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();

        querySecondmentRecordEntityList.stream().forEach(x -> {
            SecondmentRecordDTO secondmentRecordDTO = new SecondmentRecordDTO();

            BeanUtils.copyProperties(x,secondmentRecordDTO);
            Data startTime = x.getStartTime();
            Data endTime = x.getEndTime();
            int numberDays = this.numberDays((Date) startTime,(Date) endTime);
            int hoursPerDay = x.getHoursPerDay();

            secondmentRecordDTO.setDays(numberDays);
            secondmentRecordDTO.setHours(numberDays * hoursPerDay);
            secondmentRecordDTOList.add(secondmentRecordDTO);
        });
        return secondmentRecordDTOList;
    }



    /**
     * 计算两个日期的天数差
     * @param d1
     * @param d2
     * @return
     */
    public int numberDays(Date d1, Date d2){
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        //long类型的日期也支持

        cal1.setTime(d1);
        cal2.setTime(d2);

        //获取日期在一年(月、星期)中的第多少天
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);//第335天
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);//第365天

        //获取当前日期所在的年份
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);

        //如果两个日期的是在同一年，则只需要计算两个日期在一年的天数差；
        //不在同一年，还要加上相差年数对应的天数，闰年有366天
        if(year1 != year2) //不同年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0) //闰年
                {
                    timeDistance += 366;
                }
                else //不是闰年
                {
                    timeDistance += 365;
                }
            }
            System.out.println(timeDistance + (day2-day1));
            return timeDistance + (day2-day1);
        }
        else //同年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }


    /**
     * 查询
     * @param conditionsQueryDTO 查询条件
     *
     * @return Responses<List<QueryResultsDTO>> 条件查询借调记录后的结果
     **/
    @Override
    public Responses<List<QueryResultsDTO>> loanRecordConditionQuery(ConditionsQueryDTO conditionsQueryDTO) {

        List<Map> list = secondmentRecordMapper.loanRecordConditionQuery(conditionsQueryDTO);
        List<QueryResultsDTO> queryResultsDTOList = new ArrayList<>();
        list.stream().forEach(x -> {
            QueryResultsDTO queryResultsDTO = new QueryResultsDTO();
            queryResultsDTO.setProjectName(String.valueOf(x.get("projectName")));
            queryResultsDTO.setAddress(String.valueOf(x.get("address")));
            queryResultsDTO.setSendDeptCode(String.valueOf(x.get("sendDeptCode")));
            queryResultsDTO.setSendDeptName(String.valueOf(x.get("sendDeptName")));
            queryResultsDTO.setPlageName(String.valueOf(x.get("plageName")));
            queryResultsDTO.setPlageCode(String.valueOf(x.get("plageCode")));
            queryResultsDTO.setReviewStatus(String.valueOf(x.get("reviewStatus")));
            queryResultsDTO.setDeptCode(String.valueOf(x.get("deptCode")));
            queryResultsDTO.setDeptName(String.valueOf(x.get("deptName")));
            queryResultsDTO.setUpdateTime((Data) x.get("updateTime"));
            queryResultsDTO.setCreateBy(String.valueOf(x.get("createBy")));
            queryResultsDTO.setCreatorCode(String.valueOf(x.get("creatorCode")));
            queryResultsDTOList.add(queryResultsDTO);
        });
        return Responses.success(queryResultsDTOList);
    }


    /**
     * 新增/修改
     * @param secondmentIncreasedOrModifyDTO 新增/修改 参数
     *
     * @return Responses<String> 新增/修改后的结果
     **/
    @Override
    public Responses<String> secondmentIncreasedOrModify(SecondmentIncreasedOrModifyDTO secondmentIncreasedOrModifyDTO) {

        SecondmentRecordEntity secondmentRecordEntity = new SecondmentRecordEntity();

        BeanUtils.copyProperties(secondmentIncreasedOrModifyDTO,secondmentRecordEntity);
        SecondmentRecordEntity sec = secondmentRecordMapper.selectById(secondmentIncreasedOrModifyDTO.getId());
        //若存在相同id的 修改，没有则新增
        if (sec != null) {
            secondmentRecordEntity.preInsert();
            secondmentRecordMapper.insert(secondmentRecordEntity);
        } else {
            secondmentRecordMapper.updateById(secondmentRecordEntity);
        }
        return Responses.success("成功");
    }



    /**
     * 删除
     * @param id 删除的id
     *
     * @return Responses<String> 删除后信息
     **/
    @Override
    public Responses<String> secondmentRecordDeleted(Integer id) {
        SecondmentRecordEntity secondmentRecordEntity = new SecondmentRecordEntity();

        secondmentRecordEntity = secondmentRecordMapper.selectById(id);
        //1 表示删除
        secondmentRecordEntity.setDelFlag(1);
        secondmentRecordMapper.updateById(secondmentRecordEntity);

        return Responses.success();
    }


}
