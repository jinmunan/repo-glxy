package com.cj.guli.service.oss;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.net.InetAddress;


/**
 * jdbc依赖引入项目后，springboot的自动配置试图在配置文件中查找jdbc相关配置
 * 2022/6/27
 * 8:47
 * @author Jinmunan
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 取消数据源自动配置
@ComponentScan(basePackages = {"com.cj.guli"})
@Slf4j
@EnableDiscoveryClient // nacos服务注册
public class OssAppStart {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext application = SpringApplication.run(OssAppStart.class, args);
        log.info("项目启动成功！！！");

        /**
         * 启动后自动展示项目访问路径
         */
        Environment environment = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = environment.getProperty("server.port");
        String path = environment.getProperty("server.servlet.context-path");
        if (path == null) {
            path = "";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                "Application  is running! Access URLs:\n\t" +
                "Local后台管理系统访问网址: \t\thttp://localhost:" + port + path + "/backend/index.html" + "\n\t" +
                "Local前台用户页面访问网址: \t\thttp://localhost:" + port + path + "/front/page/login.html" + "\n\t" +
                "External访问网址: \thttp://" + ip + ":" + port + path + "\n\t" +
                "接口文档路径：\t\thttp://localhost:" + port + "/doc.html" + "\n\t" +
                "----------------------------------------------------------");
    }
}
