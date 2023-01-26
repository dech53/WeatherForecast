package com.example.weatherforecast;
/**
 * description ：天气预报
 * author : dech53
 * email : 2496916936@qq.com
 * date : 2023/1/23 20:30
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherforecast.Bean.DayWeatherBean;

import org.w3c.dom.Text;

import java.util.List;

public class FutureWeatherAdapter extends RecyclerView.Adapter<FutureWeatherAdapter.WeatherViewHolder> {
    private Context mContext;
    private List<DayWeatherBean> mWeatherBeans;

    public FutureWeatherAdapter(Context mContext, List<DayWeatherBean> WeatherBeans) {
        this.mContext = mContext;
        this.mWeatherBeans = WeatherBeans;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //绑定ViewHolder
        View view = LayoutInflater.from(mContext).inflate(R.layout.weather_item_layout, parent, false);
        WeatherViewHolder weatherViewHolder = new WeatherViewHolder(view);
        return weatherViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        //获取位置
        DayWeatherBean WeatherBean = mWeatherBeans.get(position);
        //设置界面控件
        holder.tvWeather.setText(WeatherBean.getWea() + "(" + WeatherBean.getDate() + ")");
        holder.tv_tem.setText(WeatherBean.getTem_day() + "°C");
        holder.tv_tem_low_high.setText(WeatherBean.getTem_night() + "°C" + "~" + WeatherBean.getTem_day() + "°C");
        holder.tv_win.setText(WeatherBean.getWin() + "(" + WeatherBean.getWin_speed() + ")");
        holder.iv_weather.setImageResource(getImgResOfWeather(WeatherBean.getWea_img()));
    }

    @Override
    public int getItemCount() {
        if (mWeatherBeans != null) {
            //返回列表长度
            return mWeatherBeans.size();
        } else {
            return 0;
        }

    }

    class WeatherViewHolder extends RecyclerView.ViewHolder {
        TextView tvWeather, tv_tem, tv_tem_low_high, tv_win;
        ImageView iv_weather;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            //绑定控件
            tvWeather = itemView.findViewById(R.id.tv_weather);
            tv_tem = itemView.findViewById(R.id.tv_tem);
            tv_tem_low_high = itemView.findViewById(R.id.tv_tem_low_high);
            tv_win = itemView.findViewById(R.id.tv_win);
            iv_weather = itemView.findViewById(R.id.iv_weather);
        }
    }

    private int getImgResOfWeather(String weaStr) {
        //判断天气情况
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
