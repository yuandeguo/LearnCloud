package com.yuan.springcloud.service.impl;

import com.yuan.springcloud.entities.Payment;
import com.yuan.springcloud.mapper.PaymentDao;
import com.yuan.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/1/11 22:03
 * @Description null
 */
@Service
public class PaymentServiceImpl implements PaymentService {

@Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
