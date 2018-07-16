package pl.oskarpolak.weathermap.views;

public class MainView {
    public void showWelcomeText(){
        System.out.println("Witaj w WeatherMap!");
        System.out.println("Jesteśmy tu, aby Ci pomóc.. <3");
    }

    public void showCityRequestText(){
        System.out.print("Podaj miasto: ");
    }

    public void showCountryRequestText(){
        System.out.print("Podaj kraj: ");
    }

    public void makeNewLine(){
        System.out.println();
    }

    public void showWeather(String weatherText){
        System.out.println(weatherText);
    }


}
