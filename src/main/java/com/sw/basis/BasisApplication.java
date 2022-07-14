package com.sw.basis;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(basePackages = {"com.sw.basis.mapper"})
@SpringBootApplication
public class BasisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasisApplication.class, args);
	}

}
