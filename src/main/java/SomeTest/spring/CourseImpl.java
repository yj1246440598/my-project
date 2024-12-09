package SomeTest.spring;

import com.enjoy.entity.Course;
import com.enjoy.mapper.CourseMapper;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class CourseImpl implements CourseMapper {
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Course> selectAll() {
        return sqlSessionTemplate.selectList("com.enjoy.CourseMapper.selectAll");
    }
}
