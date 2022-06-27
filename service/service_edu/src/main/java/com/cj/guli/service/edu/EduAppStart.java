package com.cj.guli.service.edu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * 项目启动类
 */
@Slf4j
@SpringBootApplication
// 扫描其他模块的类,加载swagger的配置文件 {跨模块的@Configuration 无法自动加载}
@ComponentScan(basePackages = {"com.cj.guli"})
@EnableDiscoveryClient // nacos服务注册
@EnableFeignClients // openfeign远程调用,消费者就是调用者，调用者添加远程调用
public class EduAppStart {
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext application = SpringApplication.run(EduAppStart.class, args);
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
