package com.example.weatherforecast;

public class WeatherInformation {
    private String Weather, Tem, TemLowHigh, Win, WeatherImg;

    @Override
    public String toString() {
        return "WeatherInformation{" +
                "Weather='" + Weather + '\'' +
                ", Tem='" + Tem + '\'' +
                ", TemLowHigh='" + TemLowHigh + '\'' +
                ", Win='" + Win + '\'' +
                ", WeatherImg='" + WeatherImg + '\'' +
                '}';
    }

    public String getWeather() {
        return Weather;
    }

    public void setWeather(String weather) {
        Weather = weather;
    }

    public String getTem() {
        return Tem;
    }

    public void setTem(String tem) {
        Tem = tem;
    }

    public String getTemLowHigh() {
        return TemLowHigh;
    }

    public void setTemLowHigh(String temLowHigh) {
        TemLowHigh = temLowHigh;
    }

    public String getWin() {
        return Win;
    }

    public void setWin(String win) {
        Win = win;
    }

    public String getWeatherImg() {
        return WeatherImg;
    }

    public void setWeatherImg(String weatherImg) {
        WeatherImg = weatherImg;
    }
}
