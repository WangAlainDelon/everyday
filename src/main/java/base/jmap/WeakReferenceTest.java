package base.jmap;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
    public static void main(String[] args) {
        Object o = new Object();
        // 默认的构造函数，会使用ReferenceQueue.NULL 作为queue
        WeakReference<Object> wr = new WeakReference<>(o);
        System.out.println(wr.get() == null);
        o = null;
        System.gc();
        System.out.println(wr.get() == null);
    }


}
