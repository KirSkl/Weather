package main.java.skladanov.weather.service;

import main.java.skladanov.weather.Dto.WeatherResponseDto;

public interface WeatherService {

    WeatherResponseDto getWeatherForecast(String city, Integer days);
}
