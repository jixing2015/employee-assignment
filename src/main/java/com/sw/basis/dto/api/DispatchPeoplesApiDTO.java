package com.sw.basis.dto.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;


/**
 * 派遣人员管理表 apiDTO
 *
 * @author jixing2000
 * @since 2022-07-22
 */
@ApiModel(value = "派遣人员管理表 apiDTO")
@Data
public class DispatchPeoplesApiDTO {

    @ApiModelProperty(value = "派遣订单号")
    private String orderId;

    @ApiModelProperty(value = "用户编号")
    private String userCode;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "派遣成本")
    private BigDecimal dispatchCost;

    @ApiModelProperty(value = "结算方式")
    private String settlement;

}