package skladanov.weather.service;

import skladanov.weather.dto.WeatherResponseDto;

public interface WeatherService {

    WeatherResponseDto getWeatherForecast(String city, Integer days);
}
