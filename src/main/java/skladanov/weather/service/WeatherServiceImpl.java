package skladanov.weather.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import skladanov.weather.client.WeatherApiClient;
import skladanov.weather.constants.WarningTemperature;
import skladanov.weather.dto.WeatherResponseDto;
import skladanov.weather.mapper.WeatherMapper;
import skladanov.weather.model.ForecastDaily;

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
        log.info("Передача данных мапперу...");
        final var response = WeatherMapper.toWeatherResponseDto(forecasts);
        log.info("Передача данных контроллеру...");
        return response;
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
