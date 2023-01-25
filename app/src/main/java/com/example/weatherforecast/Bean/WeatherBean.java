package com.example.weatherforecast.Bean;

import androidx.core.app.NotificationCompat;

import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonWriter;

import java.util.List;

public class WeatherBean {
    @SerializedName("cityid")
    private String CityId;
    @SerializedName("city")
    private String City;
    @SerializedName("update_time")
    private String Updater_time;
    @SerializedName("data")
    private List<DayWeatherBean> dayWeathers;

    @Override
    public String toString() {
        return "WeatherBean{" +
                "CityId='" + CityId + '\'' +
                ", City='" + City + '\'' +
                ", Updater_time='" + Updater_time + '\'' +
                ", dayWeathers=" + dayWeathers +
                '}';
    }

    public String getCityId() {
        return CityId;
    }

    public void setCityId(String cityId) {
        CityId = cityId;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getUpdater_time() {
        return Updater_time;
    }

    public void setUpdater_time(String updater_time) {
        Updater_time = updater_time;
    }

    public List<DayWeatherBean> getDayWeathers() {
        return dayWeathers;
    }

    public void setDayWeathers(List<DayWeatherBean> dayWeathers) {
        this.dayWeathers = dayWeathers;
    }
}
