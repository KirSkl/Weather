package skladanov.weather.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skladanov.weather.dto.WeatherResponseDto;
import skladanov.weather.service.WeatherService;

@Slf4j
@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/forecast")
    public WeatherResponseDto getWeather(@RequestParam @NotBlank String city, @RequestParam @Positive Integer days) {
        log.info(String.format("Получен GET-запрос: прогноз в городе %s на %s дней", city, days));
        final var response = weatherService.getWeatherForecast(city, days);
        log.info("Отправляю ответ пользователю...");
        return response;
    }
}
