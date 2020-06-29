package com.cloud.soft.tools;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-05 14:38
 */
public class UseSemaphore {

    public static void main(String[] args) {
        //信号量 对多个共享资源进行控制： 6个车抢3个车位
        Semaphore semaphore = new Semaphore(3);
        for(int i=1;i<=6;i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 进入");
                    TimeUnit.SECONDS.sleep(3);
                }catch (Exception ex){
                    System.out.println("异常:"+ex.toString());
                }finally {
                    semaphore.release();
                }
            },"车辆"+i).start();
        }

    }
}