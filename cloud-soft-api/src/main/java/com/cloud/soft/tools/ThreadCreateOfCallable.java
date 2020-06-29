package com.cloud.soft.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-09 17:19
 * 创建线程 可以继承Thread 实现runable接口，但是如果实现的是Callable ，Thread并无构造函数
 * jdk提供适配器模式用 futuretask关联 Thread和Callable接口 ,因为FutureTask 实现了runable接口
 * 而futuretask可以包装Callable  相同的FutureTask对象，只会被执行一次，来保证任务的唯一性，且线程安全
 */
class CallableThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("call 方法被调用");
        return 1;
    }
}

public class ThreadCreateOfCallable {


    public static void main(String[] args) throws Exception{
        FutureTask<CallableThread> futureTask = new FutureTask(new CallableThread());
        Thread t1 = new Thread(futureTask);
        t1.start();
        Thread t2 = new Thread(futureTask);
        t2.start();
        System.out.println(futureTask.get());
    }
}