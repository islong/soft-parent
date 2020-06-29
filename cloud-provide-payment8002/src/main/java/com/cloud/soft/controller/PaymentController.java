package com.cloud.soft.controller;

import com.cloud.soft.common.CommonResult;
import com.cloud.soft.entities.Payment;
import com.cloud.soft.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-03 19:57
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping(value="/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果:" + result+"  "+port);

        if(result > 0){
            return  new CommonResult(200,"插入数据库成功",result);
        } else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****插入结果:" + payment);

        if(payment != null){
            return  new CommonResult(200,"查询成功  "+port,payment);
        } else {
            return new CommonResult(444,port+ "没有对应记录，查询ID:  " + id,null);
        }
    }

}