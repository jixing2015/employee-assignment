package com.sw.basis.dto.query;

import com.sw.basis.utils.vo.Pageable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 人员维度派遣 pageDTO
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@ApiModel(value = "人员维度派遣 pageDTO")
@Data
public class personnelDimensionPageDTO extends Pageable {

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "板块")
    private String plage;

    @ApiModelProperty(value = "区域")
    private String area;

    @ApiModelProperty(value = "业务条线")
    private String line;

    @ApiModelProperty(value = "部门编号")
    private String deptCode;

    @ApiModelProperty(value = "职级编号")
    private String levelCode;

    @ApiModelProperty(value = "专长行业")
    private String specialtyIndustry;

    @ApiModelProperty(value = "专长业务类型")
    private String expertType;
}
