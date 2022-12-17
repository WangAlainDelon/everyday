package design.patterns.dp5_singleton;

public class BeanContainer {
    public static BeanContainer getInstance() {
        return HolderContainer.HOLDER.instance;
    }

    private BeanContainer() {

    }


    //容器的实例化放到了枚举的无参构造函数里面去了，这个在类加载的时候执行，所以 不会给反射和序列化的机会
    private enum HolderContainer {
        HOLDER;
        private BeanContainer instance;

        HolderContainer() {
            instance = new BeanContainer();
        }
    }

}
