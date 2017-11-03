package com.example.clearsky.repository;

import java.util.Date;
import java.util.List;

import com.example.clearsky.entity.Weather;

public interface WeatherRepository {

	Weather create(Weather weather);

	List<String> findAllCities();

	Weather getWeatherByCity(String city);

	List<Weather> getHourlyAverage(String city, Date startTime, Date endTime);

	List<Weather> getDailyAverage(String city, Date startTime, Date endTime);

}
