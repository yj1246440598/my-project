package com.enjoy.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class ListenerConfig {
    //注解触发方式
    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event){
//        System.out.println("事件触发："+event.getClass().getName());
    }
}
