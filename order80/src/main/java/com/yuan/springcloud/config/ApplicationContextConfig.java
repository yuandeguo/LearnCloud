package com.yuan.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/1/11 23:32
 * @Description RestTemplate提供http服务
 * LoadBalanced开启负载均衡，这样才能通过eureka注册的服务访问
 *
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }



}
