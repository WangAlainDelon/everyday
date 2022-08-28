package jvm.classLoader;


import java.lang.reflect.Method;

public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {

        MyClassLoader myClassLoader = new MyClassLoader(null);
//        Class<?> c1 = Class.forName("jvm.classLoader.User", true, myClassLoader);
//        User user = (User) c1.newInstance();
//        user.printClassLoader();

        Class testAClass = myClassLoader.loadClass("User");
        Object o = testAClass.newInstance();
        Method testAmainMethod  = testAClass.getDeclaredMethod("printClassLoader");
        testAmainMethod.invoke(o);
//
//
//        ClassLoader classLoader = testAClass.getClassLoader();


    }
}
