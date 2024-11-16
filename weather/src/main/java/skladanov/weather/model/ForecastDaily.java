package main.java.skladanov.weather.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ForecastDaily {
    private Integer temperature;
    private Boolean isFrost;
    private Boolean isExtremelyCold;
    private Boolean isExtremelyHot;

    public ForecastDaily(Integer temperature) {
        this.temperature = temperature;
    }
}
