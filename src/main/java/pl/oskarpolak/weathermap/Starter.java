package pl.oskarpolak.weathermap;

import pl.oskarpolak.weathermap.controllers.MainController;
import pl.oskarpolak.weathermap.models.DownloadWeatherService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.regex.Pattern;

public class Starter {
    public static void main(String[] args) {
        new MainController().start();
    }
}
