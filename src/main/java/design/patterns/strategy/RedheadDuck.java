package design.patterns.strategy;

public class RedheadDuck extends Duck {

    public RedheadDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    void display() {
        /**外观是红头鸭*/
        System.out.println("我是红头鸭");
    }
}
