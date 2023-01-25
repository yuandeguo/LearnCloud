package com.yuan.springcloud.loadBlanceRule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.DefaultResponse;
import org.springframework.cloud.client.loadbalancer.EmptyResponse;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.NoopServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.SelectedInstanceCallback;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/1/14 22:36
 * @Description 自定义负载均衡的规则，需要实现ReactorServiceInstanceLoadBalancer接口
 */
@Slf4j
public class MySelfRule implements ReactorServiceInstanceLoadBalancer {
    private int total=0;    // 被调用的次数
    private int index=0;    // 当前是谁在提供服务
    // 服务列表
    private ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider;


//构造函数
    public MySelfRule(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider) {
        this.serviceInstanceListSupplierProvider = serviceInstanceListSupplierProvider;
    }


    /**
     * 主要重写的方法，下面这些主要是模仿即可，主要写getInstanceResponse
     * @param request - an input request
     * @return
     */
    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        ServiceInstanceListSupplier supplier = serviceInstanceListSupplierProvider.getIfAvailable();
        return supplier.get().next().map(this::getInstanceResponse);
    }
//    随机负载均衡源码
//    private Response<ServiceInstance> getInstanceResponse(List<ServiceInstance> instances) {
//        if (instances.isEmpty()) {
//            if (log.isWarnEnabled()) {
//                log.warn("No servers available for service: " + serviceId);
//            }
//            return new EmptyResponse();
//        }
//        int index = ThreadLocalRandom.current().nextInt(instances.size());
//
//        ServiceInstance instance = instances.get(index);
//
//        return new DefaultResponse(instance);
//    }

    /**
     * 每五次后轮换
     * @param instances
     * @return
     */
    private Response<ServiceInstance> getInstanceResponse(List<ServiceInstance> instances) {
        if (instances.isEmpty()) {
            return new EmptyResponse();
        }
        int size = instances.size();//当前服务数量


        ServiceInstance serviceInstance=null;
        while (serviceInstance == null) {
            log.info("==========");
            if (total < 5) {
                log.info("total < 5==========total==="+total);
                serviceInstance = instances.get(index);
                total++;
            } else {
                total=0;
                index++;
                if (index>=size) {
                    index=0;
                }
                serviceInstance=instances.get(index);
            }
        }

        return new DefaultResponse(serviceInstance);
    }


}
