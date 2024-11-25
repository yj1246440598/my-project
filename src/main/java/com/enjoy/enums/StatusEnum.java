package com.enjoy.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
    ENABLE(0, "未开始"),
    DISABLED(1, "进行中");

    private final Integer code;
    private final String statusDesc;
}
