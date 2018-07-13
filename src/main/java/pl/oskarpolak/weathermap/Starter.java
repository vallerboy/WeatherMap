package pl.oskarpolak.weathermap;

import pl.oskarpolak.weathermap.models.DownloadWeatherService;

public class Starter {


    public static void main(String[] args) {
        System.out.println(DownloadWeatherService.getInstance().readWebsite("http://oskarpolak.pl"));
    }
}
