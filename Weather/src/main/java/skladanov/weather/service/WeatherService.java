package main.java.skladanov.weather.service;

import main.java.skladanov.weather.dto.WeatherResponseDto;

public interface WeatherService {

    WeatherResponseDto getWeatherForecast(String city, Integer days);
}
