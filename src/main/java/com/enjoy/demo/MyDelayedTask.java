package com.enjoy.demo;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;


public class MyDelayedTask implements Delayed {
    private String name ;
    private long start = System.currentTimeMillis();
    private long time ;

    public MyDelayedTask(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public void  getHH(){
        System.out.println("hh"+this.name);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert((start+time) - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }
    private static DelayQueue delayQueue  = new DelayQueue();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                delayQueue.offer(new MyDelayedTask("task1",10000));
                delayQueue.offer(new MyDelayedTask("task2",3900));
                delayQueue.offer(new MyDelayedTask("task3",1900));
                delayQueue.offer(new MyDelayedTask("task4",5900));
                delayQueue.offer(new MyDelayedTask("task5",6900));
                delayQueue.offer(new MyDelayedTask("task6",7900));
                delayQueue.offer(new MyDelayedTask("task7",4900));
            }
        }).start();
        while (true) {
            MyDelayedTask take = (MyDelayedTask)delayQueue.take();
            take.getHH();
        }
    }
}
