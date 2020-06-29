package com.cloud.soft.dao;

import com.cloud.soft.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-03 19:51
 */

public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}