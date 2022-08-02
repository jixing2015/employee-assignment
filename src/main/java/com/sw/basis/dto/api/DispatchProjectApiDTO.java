package com.sw.basis.dto.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 派遣项目关联表apiDTO
 *
 * @author jixing2000
 * @since 2022-07-22
 */
@ApiModel(value = "派遣项目关联表 apiDTO")
@Data
public class DispatchProjectApiDTO {

    @ApiModelProperty(value = "派遣订单号")
    private String orderId;

    @ApiModelProperty(value = "项目编号")
    private String projectCode;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

}