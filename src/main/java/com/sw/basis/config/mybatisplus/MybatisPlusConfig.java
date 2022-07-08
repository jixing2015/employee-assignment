package com.sw.basis.config.mybatisplus;

import org.springframework.context.annotation.Configuration;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @Description
 * @Author jixing2000
 * @Date 2022/3/23 0023 16:34:10
 **/
@MapperScan(basePackages = {"com.sw.basis.mapper"})
@Configuration
public class MybatisPlusConfig {


}
