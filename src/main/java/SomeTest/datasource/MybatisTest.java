package SomeTest.datasource;

import com.enjoy.mapper.CourseMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        String config = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(config);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession();
        List<Object> list = sqlSession.selectList("com.enjoy.mapper.CourseMapper.selectAll");
//        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
//        System.err.println(mapper.selectAll());
        System.out.println(list);
        sqlSession.close();
    }
}
