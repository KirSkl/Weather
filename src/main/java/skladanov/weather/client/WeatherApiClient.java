package skladanov.weather.client;

import skladanov.weather.model.ForecastDaily;

import java.util.List;

public interface WeatherApiClient {

    List<ForecastDaily> getForecast(String city, Integer days);
}
