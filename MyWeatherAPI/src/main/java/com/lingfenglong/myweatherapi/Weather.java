package com.lingfenglong.rpc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Weather {
    private String date;
    private String week;
    private String day_air_weather;
    private String night_air_weather;
    private String day_air_temperature;
    private String night_air_temperature;
    private String day_wind_power;
    private String night_wind_power;
    private String day_wind_direction;
    private String night_wind_direction;
    private String sun_begin;
    private String sun_end;
    private String quality;
}
