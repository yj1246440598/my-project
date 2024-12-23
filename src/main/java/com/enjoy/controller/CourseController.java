package com.enjoy.controller;

import com.enjoy.listener.MyTestEventPub;
import com.enjoy.mapper.CourseMapper;
import com.enjoy.service.ExcuterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private MyTestEventPub myTestEventPub;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ExcuterService excuterService;

    @RequestMapping("/a")
    @ResponseBody
    public String getAll() {
//        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("select * from teacher");
//        while (sqlRowSet.next()) {
//            int anInt = sqlRowSet.getInt(1);
//            String string = sqlRowSet.getString(2);
//            System.out.println(anInt + string);
//        }
//        System.out.println(courseMapper.selectAll());
        excuterService.print();
        myTestEventPub.pub("你好");
        return "ok";
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
