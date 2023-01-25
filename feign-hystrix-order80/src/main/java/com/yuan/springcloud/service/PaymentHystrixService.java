package com.yuan.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/1/15 23:34
 * @Description FeignClient有fallback熟悉可以设置
 * 根据cloud-consumer-feign-hystrix-order80已经有的PaymentHystrixService接口，
 * 重新新建一个类(AaymentFallbackService)实现该接口，统一为接口里面的方法进行异常处理
 *
 * PaymentFallbackService类实现PaymentHystrixService接口
 * 添加fallback = PaymentFallbackService.class
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT"
,fallback = PaymentFallbackService.class)
public interface PaymentHystrixService
{
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}

