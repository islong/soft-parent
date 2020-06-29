package com.cloud.soft.tools;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-10 11:40
 */
public class SafeArrayList {

    public static void main(String[] args) throws Exception{
//        ArrayList<String> datas = new ArrayList<>();//线程不安全
//        List<String> datas = Collections.synchronizedList(new ArrayList<String>());//线程安全
//        Vector<String> vector = new Vector();  //线程安全但是用的同步锁性能很低
        CopyOnWriteArrayList<String> datas = new CopyOnWriteArrayList<>();//线程安全
        for(int i=0;i<10;i++){
            final  int n=i;
            new Thread(()->{
                datas.add("abc"+n);
            }).start();
        }
        datas.add("abc");
        TimeUnit.SECONDS.sleep(3);
        System.out.println(datas.size()+" \t" +datas);
    }
}