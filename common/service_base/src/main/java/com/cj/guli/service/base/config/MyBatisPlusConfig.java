package com.cj.guli.service.base.config;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Jinmunan
 * 2022/6/9
 * 22:16
 */

@Configuration
@EnableTransactionManagement
// 为了扫描所有微服务包下的mapper
@MapperScan("com.cj.guli.service.*.mapper")
public class MyBatisPlusConfig {
    // 演示乐观锁
//    @Bean
//    public OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor() {
//        return new OptimisticLockerInnerInterceptor();
//    }

    // 分页插件
//    @Bean
//    public PaginationInnerInterceptor paginationInnerInterceptor() {
//        return new PaginationInnerInterceptor();
//    }
    // 插件综合体
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        // 乐观锁
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }

}
