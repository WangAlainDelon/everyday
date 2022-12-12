package design.patterns.dp2_observer.builtin;

import design.patterns.dp2_observer.custom.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;
    private Observable weatherData;

    public CurrentConditionsDisplay(Observable weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }


    @Override
    public void display() {
        System.out.println("currentConditionsDisplay:");
        System.out.println("  temperature:" + this.temperature);
        System.out.println("  humidity:" + this.humidity);
        System.out.println("  pressure:" + this.pressure);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
        }
        display();
    }
}
