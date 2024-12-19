package SomeTest.proxy;

import SomeTest.aop.AopUser;
import SomeTest.aop.UserDao;
import SomeTest.aop.UserDaoImpl;
import org.springframework.cglib.proxy.Enhancer;

public class CGlibTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDaoImpl.class);
        enhancer.setCallback(new MyCGLibProxy());
        enhancer.setInterfaces(UserDaoImpl.class.getInterfaces());

        UserDao dao = (UserDao) enhancer.create();
        dao.save(new AopUser());
    }
}
