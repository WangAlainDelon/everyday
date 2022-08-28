package juc.unsafe;

import base.base.pojo.User;
import sun.misc.Unsafe;

import java.io.File;

public class UnsafeTest {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader classLoader = User.class.getClassLoader();
        ClassLoader classLoader1 = Unsafe.class.getClassLoader();

        MyAtomicLong myAtomicLong=new MyAtomicLong();
        long andIncrement2 = myAtomicLong.getAndIncrement();


//        ClassLoader classLoader3 = MyAtomicLong.class.getClassLoader();
//        Class<?> aClass = Class.forName("juc.unsafe.MyAtomicLong", true, null);
////
////        Unsafe unsafe = Unsafe.getUnsafe();
//
//        File file=new File("src/main/java/TestController.java");
//        boolean exists = file.exists();

        //如何把类的加载请求委派给引导类
        //如何自定义加载器加载类
        //如何将非自定义的类用自定义的加载器加载

//        try {
//            MyClassLoader myClassLoader = new MyClassLoader(null);
//            Class testAClass = myClassLoader.loadClass("MyAtomicLong");
//            ClassLoader classLoader2 = testAClass.getClassLoader();
//            Class<?> aClass = Class.forName("juc.unsafe.MyAtomicLong", true, myClassLoader);
//            Object o = aClass.newInstance();
//            MyAtomicLong myAtomicLong1 = new MyAtomicLong();
//            long andIncrement1 = myAtomicLong1.getAndIncrement();
//
//            MyAtomicLong myAtomicLong = (MyAtomicLong) testAClass.newInstance();
//            long andIncrement = myAtomicLong.getAndIncrement();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        testAClass.
//        MyAtomicLong myAtomicLong = new MyAtomicLong();
//        long andIncrement = myAtomicLong.getAndIncrement();
    }
}
