package base.jmap;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    /**
     * 我们使用WeakHashMap实现的LRU缓存是有局限性的，因为他的Key只能是堆上的东西，而我们的key很多的时候都是String
     *
     */
    // 各种缓存的实现  https://blog.csdn.net/dreamzuora/article/details/107784282

    // LRU可以使用Java中的数据结构LinkedHashMap 来实现。LinkedHashMap只是每个Node节点上维护了首位指针，让他有序

    /**
     * LinkedHashMap实现了HashMap的 afterNodeInsertion(插入后置的方法)，这个方法如果执行会删除首节点，执行的条件有一个就是removeEldestEntry()
     * 方法，这个的返回值为True  LinkedHashMap就是执行afterNodeInsertion里面的逻辑，删除首节点，默认是返回的false.
     */

    private final int size;


    public LRUCache(int size) {
        super(size, 0.75f, true);
        this.size = size;
    }


    /**
     * 是不是移出最老的元素，最老的就是头节点的元素， 那是不是通过LinkedHashMap实现LRU有问题呢？如果我队首的元素经常被访问，那么这个链表满了以后还是会将它最热的数据移除哦。
     * 这不能做到缓存中最近访问最少的对象删除掉
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > this.size;
    }

    public static void main(String[] args) {



        LRUCache<String, String> lruCache = new LRUCache<>(1);
        lruCache.put("1","1");
        lruCache.put("1","2");
        //如果要实现线程安全的缓存呢？  这种做法是在每个方法上都加了锁。
        Map<String, String> stringMap = Collections.synchronizedMap(lruCache);

        // 能不能用CAS无锁编程来实现？？



    }


}
