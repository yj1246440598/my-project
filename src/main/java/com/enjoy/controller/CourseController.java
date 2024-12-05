package com.enjoy.controller;

import com.enjoy.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseMapper courseMapper;

    @RequestMapping("/a")
    @ResponseBody
    public String getAll(){
        System.out.println(courseMapper.selectAll());
        return "ok";
    }
}
