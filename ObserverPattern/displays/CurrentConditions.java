package ObserverPattern.displays;

import ObserverPattern.*;

public class CurrentConditions implements Display, Observer {

    int humidity;
    WeatherData weatherData;

    public CurrentConditions(WeatherData weatherData) {
        weatherData.subscribe(this);
        this.weatherData = weatherData;
        this.humidity = weatherData.getHumidity();
    }

    public void showData() {
        System.out.println("Humidity: " + humidity);
    }

    public void update() {
        this.humidity = weatherData.getHumidity();
    }
    
}
