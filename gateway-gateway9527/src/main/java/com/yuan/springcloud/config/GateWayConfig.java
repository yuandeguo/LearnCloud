package com.yuan.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/1/17 22:16
 * @Description 配置类实现网关配置
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder)
    {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//id随便
        routes.route("path_route_atguigu",
                r -> r.path("/guonei") //自己的地址
                        .uri("https://blog.csdn.net")).build();

        return routes.build();
    }
}
