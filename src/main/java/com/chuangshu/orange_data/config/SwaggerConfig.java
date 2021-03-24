package com.chuangshu.orange_data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Guo Jiaqi
 * @version 1.0
 * @date 2020/9/23 10:43
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket ProductApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .build()
                .apiInfo(productApiInfo());
    }

    private ApiInfo productApiInfo() {
        ApiInfo apiInfo = new ApiInfo("柑橘系统数据接口文档——数据部分",
                "该文档是柑橘小程序的后台——数据部分",
                "1.0.0",
                "API TERMS URL",
                "jiaqi_g6@163.com",
                "license",
                "license url");
        return apiInfo;
    }
}
