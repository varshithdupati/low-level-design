package ObserverPattern;

import java.util.*;
import java.util.function.*;

import ObserverPattern.displays.*;

public class Main {
    
    public static void main(String[] args) {
        
        WeatherData weatherData = new WeatherData();

        List<Supplier<? extends Display>> displays = List.of(
            () -> new CurrentConditions(weatherData),
            () -> new SimpleForecast(weatherData),
            () -> new WeatherStatistics(weatherData)
        );

        for(Supplier<? extends Display> displaySignature: displays) {
            Display display = displaySignature.get();
            display.showData();
        }

        weatherData.setData(32, 42, 22);

        for(Supplier<? extends Display> displaySignature: displays) {
            Display display = displaySignature.get();
            display.showData();
        }

    }
}
