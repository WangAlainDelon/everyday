package base.jmap;

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


    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > this.size;
    }

    public static void main(String[] args) {
        LRUCache<String, String> lruCache = new LRUCache<>(1);
        lruCache.put("1","1");
        lruCache.put("1","2");



    }


}
