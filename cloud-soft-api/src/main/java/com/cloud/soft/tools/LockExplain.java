package com.cloud.soft.tools;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-12 09:24
 */
class Phone{

    public static synchronized void mp4(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("phone---->mp4");
    }

    public  static synchronized void ebook(){
        System.out.println("phone---->ebook");
    }
}

public class LockExplain {
    public static void main(String[] args) throws  Exception{
        Phone phone = new Phone();
        Phone phone1 = new Phone();
        new Thread(()->{
            phone.mp4();
        }).start();

        TimeUnit.MILLISECONDS.sleep(200);

        new Thread(()->{
            phone1.ebook();
        }).start();
    }

}