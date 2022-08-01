package com.sw.basis.dto.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;


/**
 * 职级费率DTO
 *
 * @author jixing2000
 * @since 2022-07-29
 */
@ApiModel(value = "职级费率DTO")
@Data
public class RankRateDTO {

    @ApiModelProperty(value = "类别（职级id）")
    private String pmcatehCateid;

    @ApiModelProperty(value = "描述(职级名称)")
    private String pmcatehCatename;

    @ApiModelProperty(value = "单位成本")
    private BigDecimal pmcatehPayrate;

    @ApiModelProperty(value = "内部调用基本费率")
    private BigDecimal pmcatehBillrate;

    @ApiModelProperty(value = "内部忙季费率")
    private BigDecimal pmcatehUnitprice;

}