package com.example.weatherforecast.Bean;

import com.google.gson.annotations.SerializedName;

public class DayWeatherBean {
    @SerializedName("date")
    private String Date;
    @SerializedName("wea")
    private String Wea;
    @SerializedName("wea_img")
    private String Wea_img;
    @SerializedName("tem_day")
    private String Tem_day;
    @SerializedName("tem_night")
    private String Tem_night;
    @SerializedName("win")
    private String Win;
    @SerializedName("win_speed")
    private String Win_speed;

    @Override
    public String toString() {
        return "DayWeatherBean{" +
                "Date='" + Date + '\'' +
                ", Wea='" + Wea + '\'' +
                ", Wea_img='" + Wea_img + '\'' +
                ", Tem_day='" + Tem_day + '\'' +
                ", Tem_night='" + Tem_night + '\'' +
                ", Win='" + Win + '\'' +
                ", Win_speed='" + Win_speed + '\'' +
                '}';
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getWea() {
        return Wea;
    }

    public void setWea(String wea) {
        Wea = wea;
    }

    public String getWea_img() {
        return Wea_img;
    }

    public void setWea_img(String wea_img) {
        Wea_img = wea_img;
    }

    public String getTem_day() {
        return Tem_day;
    }

    public void setTem_day(String tem_day) {
        Tem_day = tem_day;
    }

    public String getTem_night() {
        return Tem_night;
    }

    public void setTem_night(String tem_night) {
        Tem_night = tem_night;
    }

    public String getWin() {
        return Win;
    }

    public void setWin(String win) {
        Win = win;
    }

    public String getWin_speed() {
        return Win_speed;
    }

    public void setWin_speed(String win_speed) {
        Win_speed = win_speed;
    }
}
