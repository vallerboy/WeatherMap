package pl.oskarpolak.weathermap.controllers;

import pl.oskarpolak.weathermap.views.MainView;
import java.util.Scanner;

public class MainController {
    private MainView mainView;
    private Scanner scanner;

    public MainController(){
        mainView = new MainView();
        scanner = new Scanner(System.in);
    }

    public void start() {
        mainView.showWelcomeText();

    }
}
