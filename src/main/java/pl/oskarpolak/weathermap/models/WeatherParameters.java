package pl.oskarpolak.weathermap.models;

import java.time.LocalDateTime;

public class WeatherParameters {
    private double temp;
    private LocalDateTime localDateTime;

    public WeatherParameters(double temp, LocalDateTime localDateTime) {
        this.temp = temp;
        this.localDateTime = localDateTime;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
