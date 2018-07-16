package pl.oskarpolak.weathermap.models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class DownloadWeatherService {
    private static DownloadWeatherService INSTANCE = new DownloadWeatherService();

    private DownloadWeatherService(){ }

    public static DownloadWeatherService getInstance(){
        return INSTANCE;
    }

    public List<WeatherParameters> getWeather(String cityName, String countryName){
        String url = Config.URL_TO_API + cityName + "," + countryName + "&appid=" + Config.API_KEY;
        String cleanJson = readWebsite(url);


        JSONObject root = new JSONObject(cleanJson);
        JSONArray someList = root.getJSONArray("list");

        List<WeatherParameters> weatherParametersList = new ArrayList<>();

        int localDay = 0;
        double tempSum = 0;
        int coutner = 0;

        for (int i = 0; i < someList.length(); i++) {
            JSONObject objectInArray = someList.getJSONObject(i);
            JSONObject main = objectInArray.getJSONObject("main");

            LocalDateTime localDateTime =
                    LocalDateTime.ofEpochSecond(objectInArray.getInt("dt"), 0, ZoneOffset.UTC);
            double temp = main.getDouble("temp");

            if(localDay != localDateTime.getDayOfYear()){
                weatherParametersList.add(new WeatherParameters(tempSum / coutner, localDateTime.minusDays(1)));
                localDay = localDateTime.getDayOfYear();

                tempSum =  temp;
                coutner = 1;
            }else{
                coutner ++;
                tempSum += temp;
            }

        }
        return weatherParametersList;
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
