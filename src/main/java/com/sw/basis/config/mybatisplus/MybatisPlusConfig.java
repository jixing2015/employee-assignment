package com.sw.basis.config.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author jixing2000
 * @Date 2022/3/23 0023 16:34:10
 **/
@Configuration
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件<br>
     *
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return  new PaginationInterceptor();
    }
}
