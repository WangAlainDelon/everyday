package design.patterns.observer.custom;

import java.util.ArrayList;

/**
 * 天气气压表对象
 */
public class WeatherData implements Subject {
    //新增订阅者集合属性
    private ArrayList<Observer> observerList = new ArrayList<Observer>();

    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void registerObserver(Observer o) {
        if (!observerList.contains(o)) {
            observerList.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        if (observerList.contains(o)) {
            observerList.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observerList) {
            o.update(temperature, humidity, pressure);
        }
    }

    public void measurementChanged(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}
