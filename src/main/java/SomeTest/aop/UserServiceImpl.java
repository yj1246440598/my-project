package SomeTest.aop;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(AopUser aopUser) {
        userDao.save(aopUser);
    }
}
