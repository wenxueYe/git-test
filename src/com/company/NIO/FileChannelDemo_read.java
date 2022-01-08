package com.company.NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Time : 2022/1/8 17:59
 * @Author : wenxue ye
 * @File : FileChannelDemo_read
 * @Project : git-test
 */

public class FileChannelDemo_read {
    /**
     * FileChanel读取数据到buffer中
     * @param args
     */
    public static void main(String[] args) throws Exception{

        //1.创建FileChannel
        //1.1 首先还是要获取到文件流
        RandomAccessFile accessFile = new RandomAccessFile("test.text","rw");
        FileChannel fileChannel = accessFile.getChannel();

        //创建Buffer
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //读取数据到buffer中,返回值-1时标识读取到末尾
        int byteRead;
        while((byteRead = fileChannel.read(buf)) != -1) {
            System.out.println("读取了"+byteRead);
            buf.flip();//读写模式的转换
            while(buf.hasRemaining()) {//判断为是否buf中有内容
                System.out.println((char)buf.get());
            }
            buf.clear();
        }
        accessFile.close();
        fileChannel.close();
        System.out.println("============END============");



    }
}
