package pl.oskarpolak.weathermap.controllers;

import pl.oskarpolak.weathermap.models.DownloadWeatherService;
import pl.oskarpolak.weathermap.models.WeatherParameters;
import pl.oskarpolak.weathermap.views.MainView;
import java.util.Scanner;

public class MainController {
    private MainView mainView;
    private Scanner scanner;
    private DownloadWeatherService downloadWeatherService = DownloadWeatherService.getInstance();

    public MainController(){
        mainView = new MainView();
        scanner = new Scanner(System.in);
    }

    public void start() {
        mainView.showWelcomeText();
        createMainLoop();
    }

    private void createMainLoop() {
        String userAnswerCity;
        String userAnswerCountry;
        do{
            mainView.showCityRequestText();
            userAnswerCity = scanner.nextLine();

            mainView.showCountryRequestText();
            userAnswerCountry = scanner.nextLine();

            String text = "";
            for (WeatherParameters weatherParameters : downloadWeatherService.getWeather(userAnswerCity, userAnswerCountry)) {
                text += weatherParameters.getTemp() + " / " + weatherParameters.getLocalDateTime() + "\n";
            }
            mainView.showWeather(text);
        }while (!userAnswerCity.equals("exit"));
    }
}
