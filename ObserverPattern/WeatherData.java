package ObserverPattern;

public class WeatherData {

    private int temperature, humidity, pressure;
    private WeatherSubject weatherSubject;

    public WeatherData() {
        this.temperature = 30;
        this.humidity = 40;
        this.pressure = 20;
        this.weatherSubject = new WeatherSubject();
    }

    public void subscribe(Observer observer) {
        weatherSubject.subscribe(observer);
    }

    public void unsubscribe(Observer observer) {
        weatherSubject.unsubscribe(observer);
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
        weatherSubject.notifySubscribers();
    }

}
