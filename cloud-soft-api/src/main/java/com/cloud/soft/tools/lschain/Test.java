package com.cloud.soft.tools.lschain;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-12 10:07
 */
public class Test {

    public static void main(String[] args) {
        LambadaInterface lambadaInterface = user->{
            User user1 = new User();
            List<User> users = new CopyOnWriteArrayList<>();
            user1.setId(1).setName("xi").setSalary(100.01);
            users.add(user1);
            return users;
        };
        System.out.println(lambadaInterface.getUser(1));
        System.out.println(lambadaInterface.getStrLength("===="));
        LambadaInterface.statcMethod();

        Function<String,User> function = s->{
            User user = new User();
            user.setId(s.length()).setName(s).setSalary(new Random().nextDouble());
            return user;
        };
        System.out.println(function.apply("caisj"));

        Predicate<User> predicate = user ->{
            if(user.getId()>1){
                return true;
            }else{
                return false;
            }
        };
        User user = new User();
        user.setId(2).setName("xi").setSalary(100.01);
        System.out.println(predicate.test(user));

        Consumer<String> consumer = s->{
            System.out.println("=====consumer======"+s);
        };
        consumer.accept("zhonghua");

        Supplier<String> supplier = ()->{
            return "zhonghua";
        };
        System.out.println("--->"+supplier.get());
    }
}