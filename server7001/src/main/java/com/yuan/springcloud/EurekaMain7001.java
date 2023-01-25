package com.yuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/1/12 15:54
 * @Description eurekaServer端服务注册中心
 * 测试运行EurekaMain7001，
 * 浏览器输入http://localhost:7001/回车，
 * 会查看到Spring Eureka服务主页。
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}