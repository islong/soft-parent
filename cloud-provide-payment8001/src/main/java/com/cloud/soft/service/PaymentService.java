package com.cloud.soft.service;

import com.cloud.soft.entities.Payment;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-03 19:54
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}