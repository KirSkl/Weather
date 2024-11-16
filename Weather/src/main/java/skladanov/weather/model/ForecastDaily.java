package main.java.skladanov.weather.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ForecastDaily {
    private String city;
    private String dayOfWeek;
    private Integer temperature;
    private Boolean isFrost;
    private Boolean isExtremelyCold;
    private Boolean isExtremelyHot;

    public ForecastDaily(String city, String dayOfWeek, Integer temperature) {
        this.dayOfWeek = dayOfWeek;
        this.city = city;
        this.temperature = temperature;
        isFrost = false;
        isExtremelyCold = false;
        isExtremelyHot = false;
    }
}
