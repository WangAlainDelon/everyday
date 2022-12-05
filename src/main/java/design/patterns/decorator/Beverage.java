package design.patterns.decorator;

/**
 * 咖啡原材料类
 */
public abstract class Beverage {
    public String description="Uknown Beverage";
    //叙述方法已经实理
    public String getDescription(){
        return description;
    }
    //价线必须在子类中实理
    public abstract double cost();
}
