package SomeTest.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
    private String hello;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        PersonTest contextBean = (PersonTest)context.getBean("PersonTest");
        String hello = contextBean.getHelloSpring().getHello();
        String  helloSpring = contextBean.getName();
        System.out.println(hello);
        System.out.println(helloSpring);
    }


}
