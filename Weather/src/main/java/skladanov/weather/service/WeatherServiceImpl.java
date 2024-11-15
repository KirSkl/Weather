package main.java.skladanov.weather.service;

import main.java.skladanov.weather.Dto.WeatherResponseDto;
import main.java.skladanov.weather.client.WeatherApiClient;
import main.java.skladanov.weather.model.ForecastDaily;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherApiClient weatherApiClient;

    public WeatherServiceImpl(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }

    @Override
    public WeatherResponseDto getWeatherForecast(String city, Integer days) {
        List<ForecastDaily> forecasts = weatherApiClient.getForecast(city, days);
        return null;
    }
}
