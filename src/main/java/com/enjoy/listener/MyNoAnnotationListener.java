package com.enjoy.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//非注解触发方式
@Component
public class MyNoAnnotationListener implements ApplicationListener<MyListener> {
    @Override
    public void onApplicationEvent(MyListener event) {
//        System.out.println("非注解监听器"+event.getMsg());
    }
}
