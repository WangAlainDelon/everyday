package design.patterns.dp2_observer.custom;

/**
 * 建立布告板
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;

    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        //保留Subject的引用，将来取消注册时会比较方便
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override

    public void display() {
        System.out.println("currentConditionsDisplay:");
        System.out.println("  temperature:" + this.temperature);
        System.out.println("  humidity:" + this.humidity);
        System.out.println("  pressure:" + this.pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        //把温度、湿度、压力先保存一下，再调用display方法展示
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
