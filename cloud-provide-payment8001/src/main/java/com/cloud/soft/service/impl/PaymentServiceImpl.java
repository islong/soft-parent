package com.cloud.soft.service.impl;

import com.cloud.soft.dao.PaymentDao;
import com.cloud.soft.entities.Payment;
import com.cloud.soft.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-03 19:55
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}