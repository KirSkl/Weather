package main.java.skladanov.weather.mapper;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import main.java.skladanov.weather.constants.WarningText;
import main.java.skladanov.weather.dto.WeatherResponseDto;
import main.java.skladanov.weather.model.ForecastDaily;

import java.util.*;

@UtilityClass
@Slf4j
public class WeatherMapper {

    public WeatherResponseDto toWeatherResponseDto(List<ForecastDaily> forecasts) {
        log.info("Вызван маппер погоды...");
        Map<String, String> temperatures = new HashMap<>();
        Set<String> warnings = new HashSet<>();
        WeatherResponseDto weatherResponseDto = new WeatherResponseDto();
        weatherResponseDto.setCity(forecasts.get(0).getCity());
        for (ForecastDaily forecastDaily : forecasts) {
            temperatures.put(forecastDaily.getDayOfWeek(), proceedTemper(forecastDaily.getTemperature()));
            warningsProceed(forecastDaily, warnings);
        }
        weatherResponseDto.setTemperature(temperatures);
        weatherResponseDto.setWarnings(warnings);
        return weatherResponseDto;
    }

    private String proceedTemper(Integer temperature) {
        log.info("Перевод температур в строковый формат...");
        if (temperature <= 0) {
            return temperature.toString();
        }
        return "+" + temperature.toString();
    }

    private void warningsProceed(ForecastDaily forecastDaily, Set<String> warnings) {
        log.info("Добавление предупреждений...");
        if (forecastDaily.getIsFrost()) {
            warnings.add(WarningText.FROST);
        }
        if (forecastDaily.getIsExtremelyCold()) {
            warnings.add(WarningText.EXTREMELY_COLD);
        }
        if (forecastDaily.getIsExtremelyHot()) {
            warnings.add(WarningText.EXTREMELY_HOT);
        }
    }
}
