package pl.oskarpolak.weathermap.controllers;

import pl.oskarpolak.weathermap.models.DownloadWeatherService;
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

    public void createMainLoop() {
        String userAnswer;
        do{
            mainView.showCityRequestText();
            userAnswer = scanner.nextLine();

            mainView.showWeather(downloadWeatherService.getWeather(userAnswer));
        }while (!userAnswer.equals("exit"));
    }
}
