package SomeTest.aop;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void save(AopUser aopUser) {
        System.out.println("保存了");
    }
}
