package com.enjoy.enums;

public enum ImageType {
    PNG(1,"png"),
    JPG(2,"jpg")
    ;

    private int type;
    private String context;

    ImageType(int type, String context) {
        this.type = type;
        this.context = context;
    }
}
