package design.patterns.dp1_strategy;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        /**普通鸭子呱呱叫**/
        System.out.println("呱呱叫");
    }
}
