package com.cloud.soft.io;

import java.nio.channels.Pipe;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-16 16:24
 */
public class PipeTest {

    public static void main(String[] args) throws Exception{
        Pipe pipe = Pipe.open();
    }
}