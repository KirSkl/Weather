package skladanov.weather.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import skladanov.weather.model.ForecastDaily;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Slf4j
public class WeatherApiClientImpl implements WeatherApiClient {

    //Отправка запроса внешнему сервису, заменена заглушкой с генерацией случайных данных
    @Override
    public List<ForecastDaily> getForecast(String city, Integer days) {
        log.info("Получение данных о погоде из внешнего источника...");
        return generateWeather(days, city);
    }

    private List<ForecastDaily> generateWeather(Integer days, String city) {
        log.info("Генерация случайных данных...");
        final List<ForecastDaily> forecasts = new ArrayList<>(days);
        LocalDate localDate = LocalDate.now();
        final Random random = new Random();
        for (int i = 0; i < days; i++) {
            localDate = localDate.plusDays(1);
            forecasts.add(new ForecastDaily(
                    city,
                    String.format("%s, %s-е", localDate.getDayOfWeek(), localDate),
                    random.nextInt(-50, 50)));
        }
        return forecasts;
    }
}
