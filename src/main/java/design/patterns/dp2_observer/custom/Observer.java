package design.patterns.dp2_observer.custom;

public interface Observer {
    /**
     * @param temp     温度
     * @param humidity 湿度
     * @param pressure 气压
     */
    void update(float temp, float humidity, float pressure);
}
