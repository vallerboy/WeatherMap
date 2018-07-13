package pl.oskarpolak.weathermap.models;

import javax.print.Doc;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadWeatherService {
    private static DownloadWeatherService INSTANCE = new DownloadWeatherService();

    private DownloadWeatherService(){ }

    public static DownloadWeatherService getInstance(){
        return INSTANCE;
    }

    public String getWeather(String cityName){
        String url = Config.URL_TO_API + cityName + "&appid=" + Config.API_KEY;
        return readWebsite(url);
    }

    private String readWebsite(String url){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();

            int response = 0;
            while ((response = inputStream.read()) != -1) {
                 stringBuilder.append((char) response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
