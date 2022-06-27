package com.cj.guli.service.base.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import lombok.extern.slf4j.Slf4j;
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
 * Created by Jinmunan
 * 2022/6/9
 * 22:28
 */
@Slf4j
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Swagger2Config {

	/**
	 * swagger文档对象
	 *
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		// 文档类型
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("webApi")
				.apiInfo(apiInfo())
				.select()
				// 扫描接口
				.apis(RequestHandlerSelectors.basePackage("com.cj.edu.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	/**
	 * 项目信息
	 *
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("谷粒学院支付")
				.version("1.0")
				.description("谷粒学院接口文档")
				.contact(new Contact("jinmunan", "https://www.klrss.com", "zn923042857@gmail.com"))
				.build();
	}
}
