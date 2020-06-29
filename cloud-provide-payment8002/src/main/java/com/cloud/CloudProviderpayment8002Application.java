package com.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-04 19:52
 */
@SpringBootApplication
@MapperScan("com.cloud.soft.dao")
@EnableEurekaClient
public class CloudProviderpayment8002Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderpayment8002Application.class,args);
    }
}