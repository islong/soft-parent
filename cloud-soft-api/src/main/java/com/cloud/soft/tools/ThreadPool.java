package com.cloud.soft.tools;

import java.util.concurrent.*;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-09 18:01
 */

public class ThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,
        5,
        60,
        TimeUnit.SECONDS,
        new LinkedBlockingDeque<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(executor.getQueue().size());
                TimeUnit.SECONDS.sleep(1);
                executor.submit(new Thread(() -> {
                    System.out.println("执行线程:" + Thread.currentThread().getName());
                }
                        , "name" + i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}