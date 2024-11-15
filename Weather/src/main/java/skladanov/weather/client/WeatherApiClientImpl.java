package main.java.skladanov.weather.client;

import main.java.skladanov.weather.model.ForecastDaily;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class WeatherApiClientImpl implements WeatherApiClient {

    //Отправка запроса внешнему сервису, заменена заглушкой с генерацией случайных данных
    @Override
    public List<ForecastDaily> getForecast(String city, Integer days) {
        return generateWeather(days);
    }

    private List<ForecastDaily> generateWeather(Integer days) {
        List<ForecastDaily> forecasts = new ArrayList<>(days);
        for (int i = 0; i<days; i++) {
            Random random = new Random();
            forecasts.add(new ForecastDaily(random.nextInt(-50, 50)));
        }
        return forecasts;
    }
}
