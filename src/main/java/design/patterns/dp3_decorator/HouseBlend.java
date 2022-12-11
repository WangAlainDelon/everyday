package design.patterns.dp3_decorator;


/**
 * HouseBlend是用原材料Beverage制作而来的饮料，所以他有具体的价格
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "HouseBlend";
    }

    public double cost() {
        return .89;
    }
}
