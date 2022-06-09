package com.cj.edu.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Jinmunan
 * 2022/6/9
 * 22:16
 */

@Configuration
@EnableTransactionManagement
@MapperScan("com.cj.edu.mapper")
public class MyBatisPlusConfig {
	/**
	 * SQL 执行性能分析插件
	 * 开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长
	 */
	@Bean
	@Profile({"dev", "test"})// 设置 dev test 环境开启
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		performanceInterceptor.setMaxTime(1000);//ms，超过此处设置的ms则sql不执行
		performanceInterceptor.setFormat(true);
		return performanceInterceptor;
	}

	/**
	 * 逻辑删除配置
	 * MBP3.1.1以上版本无需配置
	 * @return
	 */
	@Bean
	public ISqlInjector sqlInjector() {
		return new LogicSqlInjector();
	}
}
