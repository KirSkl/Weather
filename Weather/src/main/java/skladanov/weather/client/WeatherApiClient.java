package main.java.skladanov.weather.client;

import main.java.skladanov.weather.model.ForecastDaily;

import java.util.List;

public interface WeatherApiClient {

    List<ForecastDaily> getForecast(String city, Integer days);
}
