package design.patterns.dp1_strategy;

public abstract class Duck {
    /**
     * 鸭子的飞行行为
     */
    public FlyBehavior flyBehavior;

    /**
     * 鸭子呱呱叫的行为
     */
    public QuackBehavior quackBehavior;

    abstract void display();

    /**
     * 可以动态的设定鸭子的行为
     */
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    /**
     * 鸭子的飞行表现
     */
    public void performFly() {
        flyBehavior.fly();
    }

    /**
     * 鸭子的呱呱叫表现
     */
    public void performQuack() {
        quackBehavior.quack();
    }
}
