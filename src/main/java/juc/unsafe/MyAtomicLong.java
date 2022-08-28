package juc.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicLong;

public class MyAtomicLong {
    private static final Unsafe unsafe;
    //类的值 初始给0
    private volatile long value = 0L;
    //value在MyAtomicLong中的内存偏移地址
    private static final long valueOffset;

    static {
        try {
            //objectFieldOffset 获得value在MyAtomicLong中的内存偏移地址
//            valueOffset = unsafe.objectFieldOffset
//                    (AtomicLong.class.getDeclaredField("value"));

            //通过反射拿到成员变量theUnsafe  theUnsafe就是Unsafe的一个实例
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            //忽略访问修饰符，暴力访问
            theUnsafe.setAccessible(true);
            //取得对象的Field属性值 如果字段不是静态字段的话,要传入反射类的对象.如果传null是会报java.lang.NullPointerException
            // 如果字段是静态字段的话,传入任何对象都是可以的,包括null
            // theUnsafe是一个静态的字段  所以这里传null
            unsafe = (Unsafe) theUnsafe.get(null);
            // 获得value在MyAtomicLong中的内存偏移地址
            valueOffset = unsafe.objectFieldOffset
                    (AtomicLong.class.getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    // this这个类中，如果内存偏移地址为valueOffset的变量的值为0L,就把它替换成1L
    public final long getAndIncrement() {
        if (unsafe.compareAndSwapLong(this, valueOffset, 0L, 1L)) {
            return value;
        } else {
            throw new RuntimeException("存在两个线程竞争");
        }
    }
}
