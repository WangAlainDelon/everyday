package juc.atomicClass;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class AtomicClass {

    public static void main(String[] args) {
        // AtomicLong是rt下面 用的类加载是是BootStrap
        AtomicLong atomicLong=new AtomicLong();

        //JDK8之后高并发的类
//        LongAccumulator longAccumulator  =new LongAccumulator();
    }
}
