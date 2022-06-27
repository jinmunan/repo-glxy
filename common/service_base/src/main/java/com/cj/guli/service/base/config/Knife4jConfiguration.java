package com.cj.guli.service.base.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Created by Jinmunan
 * 2022/6/10
 * 0:00
 */
@Configuration
/*不能和swagger2一起使用 否则会爆红*/
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    @Bean
    public Docket webAPIConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(webApiInfo())
                //分组名称
                .groupName("webAPI")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.cj.guli"))
//                .paths(PathSelectors.any())
                .paths(PathSelectors.regex("/api/.*"))
                .build();
    }

    @Bean
    public Docket adminAPIConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(adminApiInfo())
                //分组名称
                .groupName("adminAPI")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.cj.guli"))
                .paths(PathSelectors.regex("/admin/.*"))
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("谷粒学苑支付")
                .description("谷粒学苑接口文档")
                // 服务条款地址
                // .termsOfServiceUrl("http://www.xx.com/")
                .contact(new Contact("jinmunan", "https://www.klrss.com", "zn9230428578@gmail.com"))
                .version("1.0")
                .build();
    }

    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("后台管理系统谷粒学苑支付")
                .description("谷粒学苑接口文档")
                // 服务条款地址
                // .termsOfServiceUrl("http://www.xx.com/")
                .contact(new Contact("jinmunan", "https://www.klrss.com", "zn9230428578@gmail.com"))
                .version("1.0")
                .build();
    }
}
