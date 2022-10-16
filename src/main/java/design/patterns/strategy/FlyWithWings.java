package design.patterns.strategy;

public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        /**实现鸭子的飞行行为*/
        System.out.println("展翅飞行");
    }
}
