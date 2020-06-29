package com.cloud.soft.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-05 11:10
 */
public class UseCyclicB {

    public static void main(String[] args) {
        //栅栏 ：开会等人齐才能开会 ，先来的人就等
        CyclicBarrier cyclicBarrier = new CyclicBarrier(6, new Runnable() {
            @Override
            public void run() {
                System.out.println("人到齐了开会");
            }
        });
        for(int i=1;i<=6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" 到场");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+ "  等待结束");
            },"线程"+i).start();
        }
    }
}