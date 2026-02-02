package ObserverPattern.displays;

import ObserverPattern.*;

public class SimpleForecast implements Display, Observer {

    int temperature;
    WeatherData weatherData;

    public SimpleForecast(WeatherData weatherData) {
        weatherData.subscribe(this);
        this.weatherData = weatherData;
        this.temperature = weatherData.getTemperature();
    }

    public void showData() {
        System.out.println("Temperature: " + temperature);
    }

    public void update() {
        this.temperature = weatherData.getTemperature();
    }
    
}
