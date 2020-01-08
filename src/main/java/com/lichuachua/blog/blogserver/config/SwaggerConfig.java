package com.lichuachua.blog.blogserver.config;

import com.lichuachua.blog.blogserver.constant.BlogConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2集成
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        //添加head参数start
        ParameterBuilder tokenParam = new ParameterBuilder();
        List<Parameter> params = new ArrayList<Parameter>();
        tokenParam.name(BlogConstant.HTTP_HEADER_WMK_ACCESS_TOKEN).description("accessToken").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        params.add(tokenParam.build());

        //添加参数到end
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(params)
                .apiInfo(apiInfo())
                .select()
                //为当前包的路径
                .apis(RequestHandlerSelectors.basePackage("com.lichuachua.blog"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Blog API")
                .version("1.0")
                .build();
    }
}
