package design.patterns.dp1_strategy;

public class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        /**橡皮鸭吱吱叫**/
        System.out.println("吱吱叫");
    }
}
