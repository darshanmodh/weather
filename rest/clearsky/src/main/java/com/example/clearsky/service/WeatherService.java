package com.example.clearsky.service;

import java.util.List;

import com.example.clearsky.entity.Weather;

public interface WeatherService {
	
	Weather create(Weather weather);
	
	List<String> findAllCities();
	
	Weather getWeatherByCity(String city);
	
	double getWeatherByCityAndProperty(String city, String prop);
	
	Weather getHourlyAverage(String city);
	
	Weather getDailyAverage(String city);

}
