package com.cloud.soft.tools.lschain;

import java.util.List;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-12 09:57
 */
@FunctionalInterface
public interface LambadaInterface {
    public List<User> getUser(Integer age);

    default public Integer getStrLength(String str){
        return str.length();
    }

    static void statcMethod(){
        System.out.println("functioninterface static method");
    }
}