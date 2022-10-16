package design.patterns.strategy;

import java.util.concurrent.locks.ReentrantLock;

public class StrategyPattern {

    /**
     *
     * 封装飞行的行为
     * 封装呱呱叫的行为
     * 这些都是变化的  这叫封装变化
     * 然后多用组合少用继承，有一个比是一个更好
     * 外观也不一样 为什么不封装外观呢？

     */
    public static void main(String[] args) {


        //需要一直呱呱叫会飞的红头鸭
        RedheadDuck redheadDuck = new RedheadDuck();
        redheadDuck.display();
        redheadDuck.performFly();
        redheadDuck.performQuack();

        //
        RedheadDuck redheadDuck2 = new RedheadDuck();
        redheadDuck2.display();
        redheadDuck2.setFlyBehavior(new FlyNoWay());
        redheadDuck2.performFly();
        redheadDuck2.performQuack();
    }
}
