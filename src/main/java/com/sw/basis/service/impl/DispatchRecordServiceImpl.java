package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.DefinedErrorEnum;
import com.sw.basis.dto.ValidateVO;
import com.sw.basis.dto.query.personnelDimensionPageDTO;
import com.sw.basis.dto.query.projectDimensionPageDTO;
import com.sw.basis.dto.request.DispatchDTO;
import com.sw.basis.dto.response.DispatchRecordDTO;
import com.sw.basis.entity.DispatchRecordEntity;
import com.sw.basis.mapper.DispatchRecordMapper;
import com.sw.basis.service.DispatchRecordService;
import com.sw.basis.service.FlowService;
import com.sw.basis.utils.RedisTemplateUtils;
import com.sw.basis.utils.Responses;
import com.sw.basis.utils.SerialNumberUtil;
import com.sw.basis.utils.constant.RedisConstant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 派遣记录表 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Service
public class DispatchRecordServiceImpl extends ServiceImpl<DispatchRecordMapper, DispatchRecordEntity> implements DispatchRecordService {

    @Resource
    RedisTemplateUtils redisUtils;
    @Resource
    FlowService flowService;

    /**
     * 项目派遣-人员维度-分页列表
     *
     * @param dto 查询条件
     * @return 分页列表
     **/
    @Override
    public Responses<IPage<DispatchRecordDTO>> pageByPersonnelDimension(personnelDimensionPageDTO dto) {
        return null;
    }

    /**
     * 项目派遣-人员维度-分页列表
     *
     * @param dto 查询条件
     * @return 分页列表
     **/
    @Override
    public Responses<IPage<DispatchRecordDTO>> pageByProjectDimension(projectDimensionPageDTO dto) {
        return null;
    }

    /**
     * 创建订单号
     * 生成规则：项目代码+PQ+三位流水号
     * @param projectCode 项目编号
     *
     * @return 订单号
     **/
    @Override
    public String createOrderId(String projectCode) {
        List<String> strList = new ArrayList<>();
        strList.add(projectCode);
        strList.add("PQ");
        long count = redisUtils.hincr(RedisConstant.PROJECT_SEQ,projectCode,RedisConstant.APPLY_ID_BY);
        Integer countDigit = 3;
        String orderId = SerialNumberUtil.createOrderId(strList,count,countDigit);
        return orderId;
    }

    /**
     * 派遣
     *
     * @param dto 表单
     * @return 成功/失败
     **/
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Responses<String> dispatch(DispatchDTO dto) {
        //创建订单号 todo 这里规则还没定好，先写个默认的
        String orderId = this.createOrderId("PROJECTCODE");
        //校验
        ValidateVO vo = new ValidateVO();
        vo.setStartTime(dto.getStartTime());
        vo.setEndTime(dto.getEndTime());
        vo.setProjectList(dto.getProjectList());
        vo.setUserList(dto.getUserList());
        Responses validateResp = flowService.validate(vo);
        //校验失败，返回提示
        if(validateResp.getError() != DefinedErrorEnum.NO_ERROR.getValue()){
            return validateResp;
        }
        //todo 派遣
        return Responses.success();
    }

    /**
     * 取消派遣
     *
     * @param dto 表单
     * @return 成功/失败
     **/
    @Override
    public Responses<String> unDispatch(DispatchDTO dto) {
        return null;
    }
}
