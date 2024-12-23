package com.enjoy.listener;

import org.springframework.context.ApplicationEvent;

public class MyListener extends ApplicationEvent {

    private String msg;
    public MyListener(Object source,String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
