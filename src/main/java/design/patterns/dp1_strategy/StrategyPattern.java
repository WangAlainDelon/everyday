package design.patterns.dp1_strategy;

public class StrategyPattern {

    /**
     *
     *
     * 需要针对鸭子Duck对象的两种行为进行封装，一种是飞行行为，一种是叫的行为。
     * 封装飞行的行为，封装呱呱叫的行为，这些都是变化的  这叫封装变化
     * 外观也不一样 为什么不封装外观呢？
     * 设计原则1:找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起
     * 设计原则2：多用组合，撒后用继承，有一个比是一个好
     * 设计原则3：针对接口编程，而不是针对实现编程 Dog dog=new Dog() 这就是针对实现，Animal animal=new Dog() 针对接口编程
     *
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
