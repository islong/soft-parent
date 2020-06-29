package com.cloud.soft.tools;

import sun.text.resources.th.FormatData_th_TH;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-05 10:20
 */
public class UseReentrantWriteAndReadLock {

    /**
     * 读写锁，比synchronized、ReentrantLock 轻量级 并发性更好
     */
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    /**
     * 模拟缓存
     */
    private volatile HashMap<String,Object> cache = new HashMap<>();


    public void getValue(String key){
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "   开始读取缓存中的数据...");
            System.out.println(Thread.currentThread().getName() + "    获取到缓存的数据:" + cache.get(key));
        }finally {
            lock.readLock().unlock();
        }
    }

    /**
     * 这个里面的所有操作应该保持原子性
     * @param key
     * @param value
     */
    public void setValue(String key ,Object value){
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "   开始设置缓存的数据...");
            cache.put(key, value);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "   设置缓存数据结束");
        }finally {
            lock.writeLock().unlock();
        }

    }

    public static void main(String[] args) {
        for(int i=1;i<5;i++) {
            final int k =i;
            new Thread(() -> {
                UseReentrantWriteAndReadLock a = new UseReentrantWriteAndReadLock();
                a.getValue("key"+k);
                a.setValue("key"+k,k);
            }, "线程" + i).start();
        }
    }
}