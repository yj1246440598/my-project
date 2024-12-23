package SomeTest.spring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyFactoryBean implements FactoryBean<HelloSpring> {
    @Override
    public HelloSpring getObject() throws Exception {
        return new HelloSpring();
    }

    @Override
    public Class<?> getObjectType() {
        return HelloSpring.class;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        //这个获取的是MyFactoryBean
        MyFactoryBean contextBean = (MyFactoryBean)context.getBean("&MyFactoryBean");
        //这个返回的是getObject方法返回的bean
        HelloSpring contextBean1 = (HelloSpring)context.getBean("MyFactoryBean");
        System.out.println(contextBean);
    }
}
