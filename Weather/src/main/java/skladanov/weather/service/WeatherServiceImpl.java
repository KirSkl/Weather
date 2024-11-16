package main.java.skladanov.weather.service;

import lombok.extern.slf4j.Slf4j;
import main.java.skladanov.weather.constants.WarningTemperature;
import main.java.skladanov.weather.dto.WeatherResponseDto;
import main.java.skladanov.weather.client.WeatherApiClient;
import main.java.skladanov.weather.mapper.WeatherMapper;
import main.java.skladanov.weather.model.ForecastDaily;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private final WeatherApiClient weatherApiClient;

    public WeatherServiceImpl(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }

    @Override
    public WeatherResponseDto getWeatherForecast(String city, Integer days) {
        final List<ForecastDaily> forecasts = weatherApiClient.getForecast(city, days);
        log.info("Проверка температур...");
        for (ForecastDaily forecastDaily : forecasts) {
            warningCheck(forecastDaily);
        }
        log.info("Передача данных контроллеру...");
        return WeatherMapper.toWeatherResponseDto(forecasts);
    }

    private void warningCheck(ForecastDaily forecastDaily) {
        final Integer temperature = forecastDaily.getTemperature();
        if (temperature < WarningTemperature.FROST) {
            forecastDaily.setIsFrost(true);
        }
        if (temperature < WarningTemperature.EXTREMELY_COLD) {
            forecastDaily.setIsExtremelyCold(true);
        }
        if (temperature > WarningTemperature.EXTREMELY_HOT) {
            forecastDaily.setIsExtremelyHot(true);
        }
    }
}
