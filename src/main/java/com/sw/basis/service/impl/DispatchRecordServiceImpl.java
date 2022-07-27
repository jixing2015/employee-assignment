package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.DefinedErrorEnum;
import com.sw.basis.dto.ValidateVO;
import com.sw.basis.dto.query.personnelDimensionPageDTO;
import com.sw.basis.dto.query.projectDimensionPageDTO;
import com.sw.basis.dto.request.DispatchDTO;
import com.sw.basis.dto.response.DispatchRecordDTO;
import com.sw.basis.dto.response.ProjectValidateDTO;
import com.sw.basis.dto.response.UserValidateDTO;
import com.sw.basis.entity.DispatchPeoplesEntity;
import com.sw.basis.entity.DispatchProjectEntity;
import com.sw.basis.entity.DispatchRecordEntity;
import com.sw.basis.mapper.DispatchRecordMapper;
import com.sw.basis.service.DispatchPeoplesService;
import com.sw.basis.service.DispatchProjectService;
import com.sw.basis.service.DispatchRecordService;
import com.sw.basis.service.FlowService;
import com.sw.basis.utils.Responses;
import com.sw.basis.utils.SerialNumberUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    FlowService flowService;
    @Resource
    DispatchRecordMapper dispatchRecordMapper;
    @Resource
    DispatchProjectService dispatchProjectService;
    @Resource
    DispatchPeoplesService dispatchPeoplesService;

    /**
     * 项目派遣-人员维度-分页列表
     *
     * @param dto 查询条件
     * @return 分页列表
     **/
    @Override
    public Responses<IPage<DispatchRecordDTO>> pageByPersonnelDimension(personnelDimensionPageDTO dto) {
        QueryWrapper<DispatchRecordEntity> wrapper = new QueryWrapper<>();
        Page<DispatchRecordEntity> page = new Page<>(dto.getPageNum(),dto.getPageSize());
        IPage<DispatchRecordEntity> iPage = dispatchRecordMapper.selectPage(page,wrapper);
        return Responses.success(iPage.convert(dispatchRecordEntity -> {
            DispatchRecordDTO dispatchRecordDTO = new DispatchRecordDTO();
            BeanUtils.copyProperties(dispatchRecordEntity,dispatchRecordDTO);
            return dispatchRecordDTO;
        }));
    }

    /**
     * 项目派遣-人员维度-分页列表
     *
     * @param dto 查询条件
     * @return 分页列表
     **/
    @Override
    public Responses<IPage<DispatchRecordDTO>> pageByProjectDimension(projectDimensionPageDTO dto) {
        QueryWrapper<DispatchRecordEntity> wrapper = new QueryWrapper<>();
        Page<DispatchRecordEntity> page = new Page<>(dto.getPageNum(),dto.getPageSize());
        IPage<DispatchRecordEntity> iPage = dispatchRecordMapper.selectPage(page,wrapper);
        return Responses.success(iPage.convert(dispatchRecordEntity -> {
            DispatchRecordDTO dispatchRecordDTO = new DispatchRecordDTO();
            BeanUtils.copyProperties(dispatchRecordEntity,dispatchRecordDTO);
            return dispatchRecordDTO;
        }));
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
        //创建订单号
        String orderId = SerialNumberUtil.createOrderId();
        //实体类转换
        List<ProjectValidateDTO> projectList = new ArrayList<>();
        List<DispatchProjectEntity> dispatchProjectEntityList = new ArrayList<>();
        if(dto.getProjectList() != null ){
            dto.getProjectList().forEach(dispatchProjectModifyDTO -> {
                ProjectValidateDTO projectValidateDTO = new ProjectValidateDTO();
                projectValidateDTO.setProjectCode(dispatchProjectModifyDTO.getProjectCode());
                projectValidateDTO.setProjectName(dispatchProjectModifyDTO.getProjectName());
                projectList.add(projectValidateDTO);
            });
            dispatchProjectEntityList = dto.getProjectList().stream().map(dispatchProjectModifyDTO -> {
                DispatchProjectEntity dispatchProjectEntity = new DispatchProjectEntity();
                BeanUtils.copyProperties(dispatchProjectModifyDTO,dispatchProjectEntity);
                return dispatchProjectEntity;
            }).collect(Collectors.toList());
        }
        List<UserValidateDTO> userList = new ArrayList<>();
        List<DispatchPeoplesEntity> dispatchPeoplesEntityList = new ArrayList<>();
        if(dto.getUserList() != null){
            dto.getUserList().forEach(dispatchPeoplesModifyDTO -> {
                UserValidateDTO userValidateDTO = new UserValidateDTO();
                userValidateDTO.setCode(dispatchPeoplesModifyDTO.getUserCode());
                userValidateDTO.setName(dispatchPeoplesModifyDTO.getUserName());
                userList.add(userValidateDTO);
            });
            dispatchPeoplesEntityList = dto.getUserList().stream().map(dispatchPeoplesModifyDTO -> {
                DispatchPeoplesEntity dispatchPeoplesEntity = new DispatchPeoplesEntity();
                BeanUtils.copyProperties(dispatchPeoplesModifyDTO,dispatchPeoplesEntity);
                return dispatchPeoplesEntity;
            }).collect(Collectors.toList());
        }
        //校验
        ValidateVO vo = new ValidateVO();
        vo.setStartTime(dto.getStartTime());
        vo.setEndTime(dto.getEndTime());
        vo.setProjectList(projectList);
        vo.setUserList(userList);
        Responses validateResp = flowService.validate(vo);
        //校验失败，返回提示
        if(validateResp.getError() != DefinedErrorEnum.NO_ERROR.getValue()){
            return validateResp;
        }
        DispatchRecordEntity dispatchRecordEntity = new DispatchRecordEntity();
        BeanUtils.copyProperties(dto,dispatchRecordEntity);
        dispatchRecordEntity.preInsert();
        dispatchRecordEntity.setOrderId(orderId);
        dispatchRecordMapper.insert(dispatchRecordEntity);
        dispatchProjectService.saveBatch(dispatchProjectEntityList);
        dispatchPeoplesService.saveBatch(dispatchPeoplesEntityList);
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

    /**
     * 跳过无法派遣的员工，派遣其他员工
     *
     * @param dto 表单
     * @return 成功/失败
     **/
    @Override
    public Responses<String> skipAndDispatchOther(DispatchDTO dto) {
        // 查询可派遣的员工
        // 派遣 todo
        DispatchDTO dispatchDTO = new DispatchDTO();
        this.dispatch(dispatchDTO);
        return null;
    }


}
