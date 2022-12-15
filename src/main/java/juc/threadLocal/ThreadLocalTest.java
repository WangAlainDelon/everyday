package juc.threadLocal;

public class ThreadLocalTest {

    /**
     * ThreadLocal里面的Map为什么不直接用HashMap来实现，而要自己实现ThreadLocalMap？
     * static class Entry extends WeakReference<ThreadLocal<?>>
     * <p>
     * 除了性能方面有提升以外，最大的特点就是ThreadLocal 可能外部没有强引用则需要被回收，如果不是 WeakReference 的，
     * 那么因为这个 Map 的强引用导致这个线程的 ThreadLocalMap 对应的 ThreadLocal key 一直不能被回收。
     * <p>
     * 也正是由于他的这个特点可能会造成内存泄露，所以用完一定要remove
     * <p>
     * 哪里还用到了这个弱引用？  tomcat的LRU缓存， JDK动态代理存放class的集合
     *
     * @param args
     */

    public static void main(String[] args) {

        Tools.threadLocal.set("hh");

    }
}
