package com.sw.basis.service;

import com.sw.basis.dto.request.ConditionsQueryDTO;
import com.sw.basis.dto.request.SecondmentIncreasedOrModifyDTO;
import com.sw.basis.dto.response.QueryResultsDTO;
import com.sw.basis.dto.response.SecondmentRecordDTO;
import com.sw.basis.entity.SecondmentRecordEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.utils.Responses;

import java.util.List;

/**
 * <p>
 * 借调记录 服务类
 * </p>
 *
 * @author donglinmo
 * @since 2022-07-26
 */
public interface SecondmentRecordService extends IService<SecondmentRecordEntity> {

    /**
     * 查询
     * @param
     *
     * @return List<SecondmentRecordDTO> 查询借调记录的结果集
     **/
    List<SecondmentRecordDTO> selectSecondmentRecord();

    /**
     * 查询
     * @param conditionsQueryDTO 查询条件
     *
     * @return Responses<List<QueryResultsDTO>> 条件查询借调记录后的结果
     **/
    Responses<List<QueryResultsDTO>> loanRecordConditionQuery(ConditionsQueryDTO conditionsQueryDTO);

    /**
     * 新增/修改
     * @param secondmentIncreasedOrModifyDTO 新增/修改 参数
     *
     * @return Responses<String> 新增/修改后的结果
     **/
    Responses<String> secondmentIncreasedOrModify(SecondmentIncreasedOrModifyDTO secondmentIncreasedOrModifyDTO);

    /**
     * 删除
     * @param id 删除的id
     *
     * @return Responses<String> 删除后信息
     **/
    Responses<String> secondmentRecordDeleted(Integer id);
}
