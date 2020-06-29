package com.cloud.soft.tools;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-11 09:35
 */

class  Ticket{
    private int count = 30;

    public synchronized void sale(){
        if(count>0) {
            System.out.println(Thread.currentThread().getName() + "  卖出第 " + count + " 张票");
            count--;
        }
    }

}
public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for(int i=0;i<50;i++) {
            new Thread(() -> {
                ticket.sale();
            }, "thread-a").start();

            new Thread(() -> {
                ticket.sale();
            }, "thread-b").start();

            new Thread(() -> {
                ticket.sale();
            }, "thread-c").start();
        }
    }
}