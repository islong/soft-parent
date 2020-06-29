package com.cloud.soft.io;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-16 14:47
 */
public class FileChannelTest {

    public static void main(String[] args) throws Exception{
        RandomAccessFile file = new RandomAccessFile("D://qiniuyun.txt","rw");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024*1024);
        int n = fileChannel.read(buf);
        while(-1!=n){
            System.out.println("read:"+n);
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char)buf.get());
            }
            buf.clear();
            n = fileChannel.read(buf);
        }
        file.close();
    }
}