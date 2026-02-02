package ObserverPattern.displays;

import ObserverPattern.*;

public class WeatherStatistics implements Display, Observer {

    int pressure;
    WeatherData weatherData;

    public WeatherStatistics(WeatherData weatherData) {
        weatherData.subscribe(this);
        this.weatherData = weatherData;
        this.pressure = weatherData.getPressure();
    }

    public void showData() {
        System.out.println("Pressure: " + pressure);
    }

    public void update() {
        this.pressure = weatherData.getPressure();
    }
    
}
