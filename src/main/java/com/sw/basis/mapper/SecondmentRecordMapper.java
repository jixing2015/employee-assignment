package com.sw.basis.mapper;

import com.sw.basis.dto.request.ConditionsQueryDTO;
import com.sw.basis.dto.response.QueryResultsDTO;
import com.sw.basis.dto.response.SecondmentRecordDTO;
import com.sw.basis.entity.QuerySecondmentRecordEntity;
import com.sw.basis.entity.SecondmentRecordEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sw.basis.utils.Responses;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 借调记录 Mapper 接口
 * </p>
 *
 * @author donglinmo
 * @since 2022-07-26
 */
@Mapper
public interface SecondmentRecordMapper extends BaseMapper<SecondmentRecordEntity> {

    List<QuerySecondmentRecordEntity> selectSecondmentRecord();

    List<Map> loanRecordConditionQuery(@Param("conditionsQueryDTO") ConditionsQueryDTO conditionsQueryDTO);
}
