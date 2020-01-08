package com.lichuachua.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.lichuachua.blog.blogserver.mapper")
@EnableSwagger2
public class BlogServerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BlogServerApplication.class, args);
	}

}
