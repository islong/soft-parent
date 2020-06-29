package com.cloud.soft.tools;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-05 10:11
 */
public class CasAndReentrantLock {


    class LockDemo {
        Lock lock = new ReentrantLock(true);//是可重入锁 也就是递归锁，一个线程获得锁后可以进而获得跟这个锁相关的被锁足的资源
        public void get() {
            lock.lock();//此处加多少个都不会报错 但是一定跟unlock配对
            try {
                System.out.println("调用get方法 当前线程:" + Thread.currentThread().getName());
                set();
            } finally {
                lock.unlock();
            }
        }

        public void set() {
            lock.lock();
            try {
                System.out.println("调用set方法 当前线程:" + Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
        }


    }

    class CasDemo {// 多线程： 共享资源、判断 操作  释放
        public volatile AtomicReference<Thread> CAS_THREAD = new AtomicReference<>();

        public void set() {
            System.out.println(Thread.currentThread().getName() + " 线程启动");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (!CAS_THREAD.compareAndSet(null, Thread.currentThread())) {

            }
            System.out.println(Thread.currentThread().getName() + " 设置值成功");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CAS_THREAD.set(null);
        }

    }

    public static void main(String[] args) {
        LockDemo lockDemo = new CasAndReentrantLock().new LockDemo();
        new Thread(() -> {
            lockDemo.get();
        }, "T1").start();
        new Thread(() -> {
            lockDemo.get();
        }, "T2").start();
        new Thread(() -> {
            lockDemo.get();
        }, "T3").start();
        new Thread(() -> {
            lockDemo.get();
        }, "T4").start();

        CasDemo casDemo = new CasAndReentrantLock().new CasDemo();
        new Thread(()->{
            casDemo.set();
        },"AA").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            casDemo.set();
        },"BB").start();
    }


}