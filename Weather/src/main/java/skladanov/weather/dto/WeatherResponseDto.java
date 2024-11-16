package main.java.skladanov.weather.dto;

import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
public class WeatherResponseDto {
    private String city;
    private Map<String, String> temperature;
    private Set<String> warnings;
}
