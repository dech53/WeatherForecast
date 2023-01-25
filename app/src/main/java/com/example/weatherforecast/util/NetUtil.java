package com.example.weatherforecast.util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetUtil {
    private static final String URL_WEATHER_WITH_FUTURE = "https://yiketianqi.com/free/week?unescape=1&appid=58546483&appsecret=5ASCA3AT";


    public static String doGet(String urlStr) {
        String result = "";
        HttpURLConnection connection = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        // 连接网络
        try {
            URL urL = new URL(urlStr);
            connection = (HttpURLConnection) urL.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);

            // 从连接中读取数据(二进制)
            InputStream inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            // 二进制流送入缓冲区
            bufferedReader = new BufferedReader(inputStreamReader);

            // 从缓存区中一行行读取字符串
            StringBuilder stringBuilder = new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            result = stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                connection.disconnect();
            }

            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return result;
    }

    public static String getWeatherOfCity(String city) {
        String weatherUrl = URL_WEATHER_WITH_FUTURE + "&city=" + city;
        Log.d("fan", "-----"+weatherUrl);
        String weatherResult = doGet(weatherUrl);
        return weatherResult;
    }
}
