package com.cloud.soft;

import com.cloud.soft.distributedlocker.DistributedLocker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-18 17:08
 */
@RestController
public class OrderController {
    public static int PRODUCT_STORE = 50;

    @Autowired
    private DistributedLocker distributedLocker;
    /**
     *
     * @return
     */
    @GetMapping("/create/{productid}")
    public String submitOrder(@PathVariable("productid") Integer productid){
        System.out.println("进入下单create..."+productid);
        try {
            //distributedLocker.lock("lock:" + productid);
            if(PRODUCT_STORE>0) {
                System.out.println("剩余库存:" + (--PRODUCT_STORE));
                TimeUnit.MILLISECONDS.sleep(10);
            }else{
                System.out.println("没有库存了");
            }
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e){

        }finally {
            //distributedLocker.unlock("lock:" + productid);
        }

        return "success";
    }
}