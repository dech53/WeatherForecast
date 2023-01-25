package com.example.weatherforecast;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherforecast.Bean.DayWeatherBean;
import com.example.weatherforecast.Bean.WeatherBean;
import com.example.weatherforecast.util.NetUtil;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppCompatSpinner mSpinner;
    private ArrayAdapter<String> mSpAdapter;
    private String[] mCities;

    private TextView tvWeather, tvTem, tvTemLowHigh, tvWin;
    private ImageView ivWeather;
    private RecyclerView rlvFutureWeather;
    private FutureWeatherAdapter futureWeatherAdapter;

    private Handler handler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                String weather = (String) msg.obj;
                Log.d("FAN", "---weather---" + weather);
                //获取Gson数据
                Gson gson = new Gson();
                WeatherBean weatherBean = gson.fromJson(weather, WeatherBean.class);
                updateUiOfWeather(weatherBean);

            }
        }
    };

    private void updateUiOfWeather(WeatherBean weatherBean) {
        if (weatherBean != null) {
            List<DayWeatherBean> dayWeathers = weatherBean.getDayWeathers();
            DayWeatherBean todayWeather = dayWeathers.get(0);
            if (todayWeather != null) {
                //设置界面数据
                tvTem.setText(todayWeather.getTem_day() + "°C");
                tvWeather.setText(todayWeather.getWea() + "(" + todayWeather.getDate() + ")");
                tvTemLowHigh.setText(todayWeather.getTem_night() + "°C" + "~" + todayWeather.getTem_day() + "°C");
                tvWin.setText(todayWeather.getWin() + "(" + todayWeather.getWin_speed() + ")");
                ivWeather.setImageResource(getImgResOfWeather(todayWeather.getWea_img()));
                Toast.makeText(MainActivity.this, "天气更新成功", Toast.LENGTH_LONG).show();
                //去除列表中的第一位城市
                dayWeathers.remove(0);
                //绑定RecycleView
                futureWeatherAdapter = new FutureWeatherAdapter(this, dayWeathers);
                rlvFutureWeather.setAdapter(futureWeatherAdapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                //设置布局样式
                rlvFutureWeather.setLayoutManager(linearLayoutManager);
            } else {
                return;
            }
        } else {
            return;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniView();
    }

    private void iniView() {
        //绑定列表
        mSpinner = findViewById(R.id.sp_city);
        mCities = getResources().getStringArray(R.array.cities);
        mSpAdapter = new ArrayAdapter<>(this, R.layout.sp_item_layout, mCities);
        mSpinner.setAdapter(mSpAdapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //判断点击的城市位置
                String selectedCity = mCities[i];
                //启动子线程请求网络
                getWeatherOfCity(selectedCity);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //控件绑定
        tvWeather = findViewById(R.id.tv_weather);
        tvTem = findViewById(R.id.tv_tem);
        tvWin = findViewById(R.id.tv_win);
        tvTemLowHigh = findViewById(R.id.tv_tem_low_high);
        ivWeather = findViewById(R.id.iv_weather);
        rlvFutureWeather = findViewById(R.id.rlv_future_weather);

    }

    private void getWeatherOfCity(String selectedCity) {
        //子线程启动请求网络
        new Thread(new Runnable() {
            @Override
            public void run() {
                //请求网络
                String weatherOfCity = NetUtil.getWeatherOfCity(selectedCity);
                //使用handler传递数据给主线程
                Message message = new Message();
                message.what = 0;
                message.obj = weatherOfCity;
                //Handler传递信息
                handler.sendMessage(message);
            }
        }).start();
    }

    //判断天气情况选择图片
    private int getImgResOfWeather(String weaStr) {
        int result = 0;
        switch (weaStr) {
            case "qing":
                result = R.drawable.biz_plugin_weather_qing;
                break;
            case "yin":
                result = R.drawable.biz_plugin_weather_yin;
                break;
            case "yu":
                result = R.drawable.biz_plugin_weather_dayu;
                break;
            case "yun":
                result = R.drawable.biz_plugin_weather_duoyun;
                break;
            case "bingbao":
                result = R.drawable.biz_plugin_weather_leizhenyubingbao;
                break;
            case "wu":
                result = R.drawable.biz_plugin_weather_wu;
                break;
            case "shachen":
                result = R.drawable.biz_plugin_weather_shachenbao;
                break;
            case "lei":
                result = R.drawable.biz_plugin_weather_leizhenyu;
                break;
            case "xue":
                result = R.drawable.biz_plugin_weather_daxue;
                break;
            default:
                result = R.drawable.biz_plugin_weather_qing;
                break;
        }

        return result;

    }
}