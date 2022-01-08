package com.company.NIO;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Time : 2022/1/8 18:22
 * @Author : wenxue ye
 * @File : FileChannelDemo_write
 * @Project : git-test
 */

public class FileChannelDemo_write {
    public static void main(String[] args) throws Exception {
        RandomAccessFile accessFile = new RandomAccessFile("test.text","rw");
        FileChannel channel = accessFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        String newData = "What's past is prologue";
        buf.clear();

        buf.put(newData.getBytes());

        buf.flip();


        while(buf.hasRemaining()) {
            channel.write(buf);
        }

        accessFile.close();

        buf.clear();

        channel.close();


    }
}
