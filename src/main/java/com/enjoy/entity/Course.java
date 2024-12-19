package com.enjoy.entity;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@ToString
public class Course {
    private int cid;
    private String cname;
    private int teacherId;
}
