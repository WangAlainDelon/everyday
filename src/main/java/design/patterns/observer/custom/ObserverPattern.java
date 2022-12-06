package design.patterns.observer.custom;

public class ObserverPattern {

    /**
     * 定义了对象之间一对多的依赖，当一个对象改变的时候，他的所有依赖者都会收到通知，并自动更新。
     * Subject改变，通知到多个Observer
     * Subject里面就是注册观察者，移除观察者，通知观察者的方法
     * Observer就有对通知做出变更的方法
     * 设计原则4：为了交互对象之间的松耦合而努力。(持有接口，而非持有实现类)
     * 背景：
     * 客户有一个WeatherData对象，负责追踪温度、湿度和气压等数据。现在客户给我们提了个需求，
     * 让我们利用WeatherData对象取得数据，并更新三个布告板：目前状况、气象统计和天气预报。
     *
     * @param args
     */


    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.measurementChanged(36.5F, 100, 500);
    }
}
