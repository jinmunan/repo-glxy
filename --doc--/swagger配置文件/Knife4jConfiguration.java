package com.cj.guli.service.edu.common.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Jinmunan
 * 2022/6/10
 * 0:00
 */
@Configuration
@EnableSwagger2
public class Knife4jConfiguration {

	// 定义分隔符,配置Swagger多包
	private static final String splitor = ";";

	@Bean(value = "createRestApi")
	public Docket createRestApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfoBuilder()
						//.title("swagger-bootstrap-ui-demo RESTful APIs")
						.description("# swagger-bootstrap-ui-demo RESTFul APIs")
						.termsOfServiceUrl("http://www.xx.com/")
						.version("1.0")
						.build())
				//分组名称
				.groupName("2.X版本")
				.select()
				//这里指定Controller扫描包路径
				// .apis(basePackage("com.cj.edu.controller"))
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
		return docket;
	}

	public static Predicate<RequestHandler> basePackage(final String basePackage) {
		return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
	}

	private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
		return input -> {
			// 循环判断匹配
			for (String strPackage : basePackage.split(splitor)) {
				boolean isMatch = input.getPackage().getName().startsWith(strPackage);
				if (isMatch) {
					return true;
				}
			}
			return false;
		};
	}

	private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
		return Optional.fromNullable(input.declaringClass());
	}
}
