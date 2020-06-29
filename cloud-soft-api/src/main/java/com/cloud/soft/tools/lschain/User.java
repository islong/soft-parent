package com.cloud.soft.tools.lschain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-12 10:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    private Integer id;
    private String name;
    private Double salary;

    public static void main(String[] args) {
        User user = new User();
        user.setId(1).setName("xi").setSalary(65.55);
        System.out.println(user.toString());
    }
}