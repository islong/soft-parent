package com.cloud.soft.tools;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-08 10:43
 */
class DeadLockTest{
    private String a =null;
    private String b =null;

    public  DeadLockTest(String a,String b){
        this.a= a;
        this.b= b;
    }

    public void methodA() throws InterruptedException {
        synchronized (a){
            System.out.println(Thread.currentThread().getName()+" 获得a锁，等待获取b锁");
            TimeUnit.SECONDS.sleep(2);
            synchronized (b){
                System.out.println("获得b锁");
            }
        }
    }

    public void methodB() throws InterruptedException {
        synchronized (b){
            System.out.println(Thread.currentThread().getName()+" 获得b锁，等待获取a锁");
            TimeUnit.SECONDS.sleep(2);
            synchronized (a){
                System.out.println("获得a锁");
            }
        }
    }
}

public class DeadLock {



    public static void main(String[] args) {
        /**
         *造成死锁

        new Thread(()->{
            try {
                new DeadLockTest("a","b").methodA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                new DeadLockTest("b","a").methodA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
         */
//        byte [] bytes = new byte[300*1024*102];  //故意造成heap space -XX:+PrintGCDetails -Xms10m -Xmx10m -XX:+PrintCommandLineFlags
        int i=0;
        while(true){
            System.out.println("================="+(++i));
            ByteBuffer buffer =  ByteBuffer.allocateDirect(1024);
        }
    }

}