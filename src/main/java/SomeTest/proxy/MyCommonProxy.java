package SomeTest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyCommonProxy implements InvocationHandler {

    private Object object;

    public MyCommonProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object, args);
    }

}
