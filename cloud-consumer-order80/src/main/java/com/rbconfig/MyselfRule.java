package com.rbconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-05 19:10
 */

@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}