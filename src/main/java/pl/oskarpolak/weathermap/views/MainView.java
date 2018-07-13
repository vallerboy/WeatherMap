package pl.oskarpolak.weathermap.views;

public class MainView {
    public void showWelcomeText(){
        System.out.println("Witaj w WeatherMap!");
        System.out.println("Jesteśmy tu, aby Ci pomóc.. <3");
    }

    public void showCityRequestText(){
        System.out.print("Podaj miasto: ");
    }

    public void showWeather(String weatherText){
        System.out.println(weatherText);
    }


}
