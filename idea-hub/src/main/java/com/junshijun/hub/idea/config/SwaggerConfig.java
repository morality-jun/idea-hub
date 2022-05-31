package com.junshijun.hub.idea.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableOpenApi
@EnableKnife4j
public class SwaggerConfig {

    @Bean
    @Profile({"dev"})
    public Docket restApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("标准接口")
                .apiInfo(apiInfo("Spring Boot中使用Swagger3构建RESTful APIs", "3.0"))
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .select()
                //这里写自己的controller包
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://localhost:9091/swagger-ui/index.html
     *
     * @return
     */
    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfoBuilder()
                .title(title)
                .description("更多请关注: https://blog.csdn.net/xqnode")
                .termsOfServiceUrl("https://blog.csdn.net/xqnode")
                .contact(new Contact("Xiao白码", "https://blog.csdn.net/xqnode", "1468799392@qq.com"))
                .version(version)
                .build();
    }
}
