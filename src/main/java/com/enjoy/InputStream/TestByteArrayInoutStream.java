package com.enjoy.InputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TestByteArrayInoutStream {
    public static byte[] bytes = new byte[100];

    static {
        for (byte i = 0; i < 100; i++) {
            bytes[i] = i;
        }
    }

    public static void main(String[] args) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        System.out.println(byteArrayInputStream.available());

        byteArrayInputStream.skip(33);
        System.out.println(byteArrayInputStream.available());

        while (33<byteArrayInputStream.read()){
            System.out.println(byteArrayInputStream.read());
            System.out.println(byteArrayInputStream.available());
        }
        byteArrayInputStream.mark(89);
        byte[] markB = new byte[byteArrayInputStream.available()];
        while((byteArrayInputStream.read(markB, 0, markB.length)) != -1){
            for(byte b : markB){
                System.out.print(b + " ");
            }
        }
        System.out.println("\n");
        byteArrayInputStream.reset();
        byte[] reset = new byte[byteArrayInputStream.available()];
        while((byteArrayInputStream.read(reset, 0, markB.length)) != -1){
            for(byte b : reset){
                System.out.print(b + " ");
            }
        }
        //测试本地git上传
    }
}
