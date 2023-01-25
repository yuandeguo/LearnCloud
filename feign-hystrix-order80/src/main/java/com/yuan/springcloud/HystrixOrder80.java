package com.yuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/1/15 23:33
 * @Description 对客户端进行降级保护
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixOrder80 {
    public static void main(String[] args)
    {
        SpringApplication.run(HystrixOrder80.class,args);
    }
}
