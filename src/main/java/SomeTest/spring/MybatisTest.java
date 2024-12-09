package SomeTest.spring;

import com.enjoy.mapper.CourseMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        CourseMapper userMapper = (CourseMapper) context.getBean("courseMapper");
        System.out.println(userMapper.selectAll());
    }
}
