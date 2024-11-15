package main.java.skladanov.weather.Dto;

import lombok.Data;
import java.util.List;

@Data
public class WeatherResponseDto {
    private List<String> temperature;
    private List<String> warnings;
}
