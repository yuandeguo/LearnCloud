package com.yuan.springcloud.service;

import com.yuan.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/1/11 22:02
 * @Description null
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
