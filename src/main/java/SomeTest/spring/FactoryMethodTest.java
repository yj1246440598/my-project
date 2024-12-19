package SomeTest.spring;


public class FactoryMethodTest{

    public static HelloSpring createHello(){
        return new HelloSpring();
    }

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
//        HelloSpring contextBean = (HelloSpring)context.getBean("FactoryMethodTestId");
//        System.out.println(contextBean);
    }
}
