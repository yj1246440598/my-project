package com.enjoy.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Course {
    private int cid;
    private String cname;
    private int teacherId;
}
