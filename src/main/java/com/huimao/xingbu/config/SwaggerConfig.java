/**
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huimao.xingbu.config;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

/**
 * SwaggerConfig
 *
 * @ClassName: SwaggerConfig
 * @Description: SwaggerConfig
 * @author: yangwen
 * @since 2021-09-10
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * api
     *
     * @return 返回值
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
            .pathMapping("/")
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
            .paths(PathSelectors.regex("/.*")) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("ManageOne 8.0.3 对接 ICOS")
            .description("")
            .contact(new Contact("", "", ""))
            .version("1.0.0")
            .license("")
            .licenseUrl("")
            .build();
    }
}
