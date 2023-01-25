package com.yuan.springcloud.service;

import com.yuan.springcloud.entities.CommonResult;
import com.yuan.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * value服务名称
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",contextId = "payment-core")
public interface  PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
     CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
    @GetMapping(value = "/payment/feign/timeout")
     String paymentFeignTimeout();

}
