package com.cloud.soft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cloud.soft.dao")
public class CloudProvidePayment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProvidePayment8001Application.class, args);
    }

}
