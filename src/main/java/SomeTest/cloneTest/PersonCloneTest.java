package SomeTest.cloneTest;

import com.enjoy.entity.Course;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PersonCloneTest implements  Cloneable{
    private String name;
    private Course course;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
