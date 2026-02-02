package ObserverPattern;

import java.util.*;

public class WeatherData implements Subject {

    private int temperature, humidity, pressure;
    private List<Observer> subscribers;

    public WeatherData() {
        this.temperature = 30;
        this.humidity = 40;
        this.pressure = 20;
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    public void notifySubscribers() {
        for(Observer observer: subscribers) {
            observer.update();
        }
    }
    
    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setData(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public void measurementsChanged() {
        notifySubscribers();
    }

}
