package SomeTest.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {

    public HelloSpring create(){
        return new HelloSpring();
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        FactoryBeanTest contextBean = (FactoryBeanTest)context.getBean("FactoryBeanTestId");
        System.out.println(contextBean.create());
    }
}
