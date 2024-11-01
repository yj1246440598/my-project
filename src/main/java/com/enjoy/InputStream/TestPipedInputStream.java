package com.enjoy.InputStream;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TestPipedInputStream {
    public static void main(String[] args) throws IOException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();

        // 连接管道输入流和输出流
        pipedOutputStream.connect(pipedInputStream);

        // 写入数据到管道
        pipedOutputStream.write("Hello, Piped Stream!".getBytes());

        // 读取管道数据
        byte[] buffer = new byte[1024];
        int bytesRead = pipedInputStream.read(buffer);

        // 转换为字符串并打印
        System.out.println("Read: " + new String(buffer, 0, bytesRead));

        // 关闭管道
        pipedOutputStream.close();
        pipedInputStream.close();
    }
}
