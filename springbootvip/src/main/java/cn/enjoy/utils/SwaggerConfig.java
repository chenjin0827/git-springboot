package cn.enjoy.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 的作用
 	随项目自动生成强大RESTful API文档，减少工作量
 	API文档与代码整合在一起，便于同步更新API说明
 	页面测试功能来调试每个RESTful API

 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        /**
         * DocumentationType 文档类型
         * apiInfo就是具体信息
         * basePackage 扫描那个包
         * any 任何的都要
         */
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.enjoy"))// 指定扫描包下面的注解
                .paths(PathSelectors.any())
                .build();
    }

    // 创建api的基本信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("集成Swagger2构建RESTful APIs")
                .description("集成Swagger2构建RESTful APIs")
                .termsOfServiceUrl("http://www.xiangxueketang.cn/")
                .contact(new Contact("enjoy", "cn.xiangxueketang", "enjoy@enjoy.cn"))
                .version("1.0.0")
                .build();
    }
}
