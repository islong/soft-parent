package com.cloud.soft.tools;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-05 10:50
 */
public class UseCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        //秦始皇一统六国，前提六国被灭 才能统一
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for(int i=1;i<=6;i++) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println(Thread.currentThread().getName());  灭国
                try {
//                    countDownLatch.countDown();  灭国
                    countDownLatch.await();
                    System.out.println(Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, Country.getCountryByCode(i).getName() + ":被灭").start();
        }
        try {
//            countDownLatch.await(1, TimeUnit.SECONDS);//此处1s表示等待1返回 不管其他任务有没有执行完
//            countDownLatch.await();//阻塞等待
            TimeUnit.SECONDS.sleep(2);
            countDownLatch.countDown();
            System.out.println("秦始皇一统天下");
        }catch (InterruptedException ex){
            System.out.println("===========异常  ");
        }
    }
}