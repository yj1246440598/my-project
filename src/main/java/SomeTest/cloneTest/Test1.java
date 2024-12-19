package SomeTest.cloneTest;

import com.enjoy.entity.Course;

public class Test1 {


    public static void main(String[] args) throws CloneNotSupportedException {
        PersonCloneTest personCloneTest = new PersonCloneTest();
        personCloneTest.setName("张三");
        Course course = new Course();
        course.setCid(1);
        course.setCname("哈哈");
        course.setTeacherId(101);
        personCloneTest.setCourse(course);

        PersonCloneTest clone = (PersonCloneTest)personCloneTest.clone();
        clone.getCourse().setTeacherId(102);
        clone.setName("李四");
        System.out.println(personCloneTest);
        System.out.println(clone);
    }
}
