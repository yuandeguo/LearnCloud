package com.yuan.springcloud;

import com.yuan.springcloud.loadBlanceRule.MySelfRule;
import com.yuan.springcloud.loadBlanceRule.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/1/11 23:01
 * @Description 用户端
 *
 * LoadBalancerClient配置负载均衡的分配策略
 * name为哪个服务，configuration为配置类
 */
@SpringBootApplication
@EnableEurekaClient
@LoadBalancerClient(name ="CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
