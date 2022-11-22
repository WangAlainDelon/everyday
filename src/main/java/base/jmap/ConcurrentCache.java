package base.jmap;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ]
 * 基于WeakHashMap 实现线程安全的缓存
 *
 * @param <K>
 * @param <V>
 */
public class ConcurrentCache<K, V> {



    /**
     * 常驻缓存大小
     */
    private final int size;

    /**
     * 常驻内存大小
     */
    private final Map<K, V> eden;

    //存放多余的内容
    private final Map<K, V> longterm;

    public ConcurrentCache(int size) {
        this.size = size;
        eden = new ConcurrentHashMap<>(size);
        longterm = new WeakHashMap<>(size);
    }


    public V get(K k) {
        //从常驻缓存中获取内容
        V v = this.eden.get(k);
        if (v == null) {
            synchronized (longterm) {
                v = this.longterm.get(k);
            }
            //非常住缓存如果不为空，那么尝试将内容存放在eden
            if (v != null) {
                this.eden.put(k, v);
            }
        }
        return v;
    }

    public void put(K k, V v) {
        //如果超过常驻缓存的大小
        if (this.eden.size() >= size) {
            synchronized (longterm) {
                this.longterm.putAll(this.eden);
            }
            //清空常驻缓存
            this.eden.clear();
        }
        this.eden.put(k, v);
    }


}
