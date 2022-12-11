package design.patterns.dp2_observer.builtin;


public class ObserverPattern {

    /**
     * 内置的观察者模式和自定义实现的观察者模式的区别:
     *  自己实现的一般只能从主题推送到观察者，而Java内置的可以实现推拉消息，
     *  我们一般认为主题主动推的方式是正确的。但是无法保证顺序通知哦。
     *  这个对顺序有要求的就不能使用这种内置的方式。自定义的是实现接口，而使用Java内置的只能是继承他的类。
     *
     * @param args
     */
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay=new CurrentConditionsDisplay(weatherData);
        weatherData.measurementChanged(36.5F, 100, 500);
    }
}
