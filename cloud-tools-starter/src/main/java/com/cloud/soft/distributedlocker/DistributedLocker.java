package com.cloud.soft.distributedlocker;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-18 16:04
 */
public interface DistributedLocker {
    RLock lock(String lockKey);

    RLock lock(String lockKey, int timeout);

    RLock lock(String lockKey, TimeUnit unit, int timeout);

    boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime);

    void unlock(String lockKey);

    void unlock(RLock lock);
}