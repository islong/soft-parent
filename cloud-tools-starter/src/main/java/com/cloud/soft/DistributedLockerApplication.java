package com.cloud.soft;

import com.cloud.soft.distributedlocker.DistributedLocker;
import com.cloud.soft.distributedlocker.RedissonProperties;
import com.cloud.soft.distributedlocker.impl.DistributedLockerImpl;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConditionalOnClass({Config.class})
@EnableConfigurationProperties({RedissonProperties.class})
public class DistributedLockerApplication {
    @Autowired
    private RedissonProperties redissonProperties;

    public static void main(String[] args) {
        SpringApplication.run(DistributedLockerApplication.class, args);
    }


    @Bean
    @ConditionalOnProperty(name="redisson.address")
    RedissonClient redissonSingle() {
        Config config = new Config();
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(redissonProperties.getAddress())
                .setTimeout(redissonProperties.getTimeout())
                .setConnectionPoolSize(redissonProperties.getConnectionPoolSize())
                .setConnectionMinimumIdleSize(redissonProperties.getConnectionMinimumIdleSize());

        if (null != redissonProperties.getPassword() && !"".equals(redissonProperties.getPassword())) {
            serverConfig.setPassword(redissonProperties.getPassword());
        }
        return Redisson.create(config);
    }

    @Bean("distributedLocker")
    DistributedLocker distributedLocker(RedissonClient redissonClient) {
        DistributedLocker distributedLocker = new DistributedLockerImpl();
        ((DistributedLockerImpl) distributedLocker).setRedissonClient(redissonClient);
        return distributedLocker;
    }
}
