package main.java.skladanov.weather.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import main.java.skladanov.weather.dto.WeatherResponseDto;
import main.java.skladanov.weather.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/forecast")
    public WeatherResponseDto getWeather(@NotBlank @RequestParam String city, @Positive @RequestParam Integer days) {
        log.info(String.format("Получен GET-запрос: прогноз в городе %s на %s дней", city, days));
        return weatherService.getWeatherForecast(city, days);
    }
}
