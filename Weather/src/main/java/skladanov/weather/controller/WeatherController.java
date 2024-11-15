package main.java.skladanov.weather.controller;

import lombok.extern.slf4j.Slf4j;
import main.java.skladanov.weather.Dto.WeatherResponseDto;
import main.java.skladanov.weather.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public WeatherResponseDto getWeather(String city, int days) {
        log.info(String.format("Получен GET-запрос: прогноз в городе %s на %s дней", city, days));
        return weatherService.getWeatherForecast(city, days);
    }
}
