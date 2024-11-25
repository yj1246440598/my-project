package com.enjoy.demo;

import org.springframework.util.ReflectionUtils;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

public class MySynchronousQueue {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        new Thread(()->{
            queue.offer(new Random().nextInt());
        }).start();
        new Thread(()->{
            try {
                Integer take = queue.take();
                System.out.println(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
       Thread.sleep(10000);
    }
}
