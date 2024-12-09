package SomeTest.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;


@Aspect
public class UserServiceLogger {
    private static Logger logger = Logger.getLogger("UserServiceLogger");

    @Before("execution(public void addUser(AopUser))")
    public void before(JoinPoint joinpoint) {
        logger.info("调用" + joinpoint.getTarget() + "方法" + joinpoint.getSignature() + "参数" + Arrays.toString(joinpoint.getArgs()));
    }

    public void afterReturn(JoinPoint joinpoint, Object result) {
        logger.info("调用" + joinpoint.getTarget() + "方法" + joinpoint.getSignature() + "返回值" + result);
    }


    public void afterThrowing(JoinPoint joinpoint) throws IOException {
        logger.info("调用" + joinpoint.getTarget() + "方法" + joinpoint.getSignature() + "返回值" );
        throw new IOException("失败");
    }


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:Context.xml");
        UserService userService = (UserService) context.getBean("userService");
//        AopUser user = (AopUser) context.getBean("user");
//        System.out.println(user);
        userService.addUser(new AopUser());
    }
}
