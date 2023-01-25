package com.yuan.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/1/15 15:30
 * @Description EnableHystrix开启Hystrix
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class HygtrixPayment8001 {
    public static void main(String[] args) {
        SpringApplication.run(HygtrixPayment8001.class, args);
    }

}
