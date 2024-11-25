package com.enjoy.entity;

public enum ResponseCode {
    SUCCESS(200,"成功"),
    ERROR(500,"失败"),
    ;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
