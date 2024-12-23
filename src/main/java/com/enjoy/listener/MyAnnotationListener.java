package com.enjoy.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyAnnotationListener {
    @EventListener
    public void  listener1(MyListener listener){
//        System.out.println("注解监听器1："+ listener.getMsg());
    }
}
