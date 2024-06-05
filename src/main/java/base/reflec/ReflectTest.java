package base.reflec;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    /**
     * 获取class对象的方式有多少种？
     * 通过SagaTask注解可以找到要执行的的类的Class对象。然后通过反射调用方法
     */

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {


        User user = new User();
        user.setId(10L);

        Class<? extends User> aClass1 = user.getClass();

        Field name = aClass1.getDeclaredField("id");
        name.setAccessible(true);
        Object o = name.get(user);
        String ref = "base.reflec.UserServiceImpl";
        Class<?> aClass = Class.forName(ref);
        Method createUser = aClass.getMethod("createUser", Long.class);
        createUser.invoke(aClass.newInstance(), 10L);

    }
}
