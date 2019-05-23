package com.yunding.weimuke;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.yunding.weimuke.weimukeserver.mapper")
@EnableSwagger2
public class WeimukeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WeimukeApplication.class, args);
	}

}
