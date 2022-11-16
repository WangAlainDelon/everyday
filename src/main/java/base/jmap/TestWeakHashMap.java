package base.jmap;

import base.base.pojo.User;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class TestWeakHashMap {

    public static void main(String[] args) {
        //总结来说：WeakHashMap并不是你啥也干他就能自动释放内部不用的对象的，而是在你访问它的内容的时候释放内部不用的对象。这两句话看似区别不大，但是有时候一个小小的区别就会要了命的。

        /**
         * 弱引用的哈希表
         * 实现对“键值对”的动态回收。当“弱键”不再被使用到时，GC会回收它，WeakReference也会将“弱键”对应的键值对删除。
         * leetcode  LRU  https://leetcode.cn/problems/lru-cache/
         * */


        //实际应用： 可以基于WeakHashMap 实现一个线程安全的基于LRU本地缓存
        // 我们的网关就有本地的缓存


        Map<String, String> linkHashMap = new LinkedHashMap<>(1);
        linkHashMap.put("1", "1");
        linkHashMap.put("2", "2");


        //1.WeakHashMap的使用  实现就是WeakReference为null的时候，就会被计入回收队列，GC的时候就会回收掉。
        User user = new User(1L);
//        Object key = new Object();
//        String key = "user";  // 非堆内存不能被回收
        String key = new String();  //只有堆上的内存才能被回收
        // 如果Key是存在常量池中的，Java8的常量池已经移出堆了，所以这里使用String类型的是实现不了GC回收的。

        WeakHashMap weakHashMap = new WeakHashMap<Object, User>();
        weakHashMap.put(key, user);
        key = null;
        System.gc();
        weakHashMap.get(key);


    }
}
