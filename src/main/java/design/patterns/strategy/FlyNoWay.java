package design.patterns.strategy;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        /**不会飞**/
        System.out.println("不会飞");
    }
}
