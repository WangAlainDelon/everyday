package design.patterns.decorator;

/**
 *
 *  Espresso是用原材料Beverage制作而来的饮料，所以他有具体的价格
 */
public class Espresso extends Beverage {
    //设置饮料的描述
    public Espresso() {
        description = "Espresso";
    }

    //计算Espresso的价钱，现在不需要管调料的价钱
    public double cost() {
        return 1.99;
    }
}
