package com.cloud.soft.tools;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-10 16:32
 */
public class ABCPrint {

    private ReentrantLock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private volatile Integer flag =1;

    public void printA(){
        try{
            lock.lock();
            while(flag!=1){
                conditionA.await();
            }
            System.out.println(Thread.currentThread().getName()+"   print A");
            flag=2;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        try {
            lock.lock();
            while(flag!=2){
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName() + "   print B");
            flag=3;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

        public void printC(){
            try{
                lock.lock();
                while(flag!=3){
                    conditionC.await();
                }
                System.out.println(Thread.currentThread().getName()+"   print C");
                flag=1;
                conditionA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
    }

    /**
     *  线程 资源 控制类
     *  判断 干活 唤醒
     *  防止重复唤醒
     *  第一次 打印五次ABC
     *  第二次 打印十次ABC
     */

    public static void main(String[] args) {
        ABCPrint print = new ABCPrint();
            new Thread(()->{
                for(int i=1;i<=5;i++) {
                    print.printA();
                }
            },"A-thread").start();

            new Thread(()->{
                for(int i=1;i<=5;i++) {
                    print.printB();
                }
            },"B-thread").start();

            new Thread(()->{
                for(int i=1;i<=5;i++) {
                    print.printC();
                }
            },"C-thread").start();
        }
}