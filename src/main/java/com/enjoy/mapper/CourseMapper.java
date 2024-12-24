package com.enjoy.mapper;

import com.enjoy.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CourseMapper {
     List<Course> selectAll();
}
