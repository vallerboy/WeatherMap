package pl.oskarpolak.weathermap;

import pl.oskarpolak.weathermap.controllers.MainController;
import pl.oskarpolak.weathermap.models.DownloadWeatherService;

public class Starter {
    public static void main(String[] args) {
        new MainController().start();
    }
}
