package com.cloud.soft.tools;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: soft-parent
 * @description:  第一代 sync wait notify  第二代 lock await signel  第三代  阻塞队列
 * @author: caiSJ
 * @create: 2020-06-10 10:11
 */
public class SyncQueue {
    public static SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

    public static void producer(){
        try {
//            System.out.println(Thread.currentThread().getName()+":生产消息");
            System.out.println(Thread.currentThread().getName()+" 生产消息");
            synchronousQueue.put("我是土豆");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void consumer(){
        try {
            TimeUnit.SECONDS.sleep(2);
//            System.out.println(Thread.currentThread().getName()+" 开始消费消息");
            System.out.println(Thread.currentThread().getName()+" 消费消息:"+synchronousQueue.poll());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws  Exception{
                new Thread(()->{
                    while(true) {
                        SyncQueue.producer();
                    }
                },"producer").start();
            TimeUnit.SECONDS.sleep(2);
            new Thread(()->{
                while(true) {
                    SyncQueue.consumer();
                }
            },"consumer").start();
        }

}