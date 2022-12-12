package design.patterns.dp1_strategy;

public class RubberDuck extends Duck {
    public RubberDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new Squeak();
    }

    @Override
    void display() {
        /**外观是橡皮鸭*/
        System.out.println("我是橡皮鸭");
    }
}
