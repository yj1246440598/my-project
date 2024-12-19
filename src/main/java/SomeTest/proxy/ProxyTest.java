package SomeTest.proxy;


import SomeTest.aop.AopUser;
import SomeTest.aop.UserDao;
import SomeTest.aop.UserDaoImpl;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        UserDao userDao =(UserDao) Proxy.newProxyInstance(UserDaoImpl.class.getClassLoader(),
                 UserDaoImpl.class.getInterfaces(), new MyCommonProxy(new UserDaoImpl()));
        userDao.save(new AopUser());
    }
}
