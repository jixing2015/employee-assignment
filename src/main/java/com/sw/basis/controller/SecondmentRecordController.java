package com.sw.basis.controller;


import com.sw.basis.annotation.Log;
import com.sw.basis.dto.request.ConditionsQueryDTO;
import com.sw.basis.dto.request.SecondmentIncreasedOrModifyDTO;
import com.sw.basis.dto.response.QueryResultsDTO;
import com.sw.basis.dto.response.SecondmentRecordDTO;
import com.sw.basis.service.SecondmentRecordService;
import com.sw.basis.utils.Responses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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


    private static final String SELECT = "借调历史记录";
    @Log(desc = SELECT, type = Log.LOG_TYPE.SELECT)
    @ApiOperation(value = SELECT)
    @PostMapping("/secondmentInquiry")
    public Responses<List<SecondmentRecordDTO>> secondmentInquiry () {
        List<SecondmentRecordDTO> secondmentRecordEntityList = secondmentRecordService.selectSecondmentRecord();
        return Responses.success(secondmentRecordEntityList);
    }



    private static final String CONDITIONS_QUERY = "借调_列表";
    @Log(desc = CONDITIONS_QUERY, type = Log.LOG_TYPE.SELECT)
    @ApiOperation(value = CONDITIONS_QUERY)
    @PostMapping("/loanRecordConditionQuery")
    public Responses<List<QueryResultsDTO>> loanRecordConditionQuery (@RequestBody ConditionsQueryDTO conditionsQueryDTO) {
        return secondmentRecordService.loanRecordConditionQuery(conditionsQueryDTO);
    }


    private static final String CONDITIONS_ADD = "借调记录增加或修改";
    @Log(desc = CONDITIONS_ADD, type = Log.LOG_TYPE.ADD)
    @ApiOperation(value = CONDITIONS_ADD)
    @PostMapping("/secondmentIncreasedOrModify")
    public Responses<String> secondmentIncreasedOrModify (@RequestBody SecondmentIncreasedOrModifyDTO secondmentIncreasedOrModifyDTO) {
        return secondmentRecordService.secondmentIncreasedOrModify(secondmentIncreasedOrModifyDTO);
    }


    private static final String CONDITIONS_DELETE = "借调记录删除";
    @Log(desc = CONDITIONS_DELETE, type = Log.LOG_TYPE.DEL)
    @ApiOperation(value = CONDITIONS_DELETE)
    @PostMapping("/secondmentRecordDeleted")
    public Responses<String> secondmentRecordDeleted (@RequestParam(value = "id") Integer id) {
        return secondmentRecordService.secondmentRecordDeleted(id);
    }




}

