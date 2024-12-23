package com.enjoy.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MyTestEventPub {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void pub(String msg){
        applicationEventPublisher.publishEvent(new MyListener(this,msg));
    }
}
