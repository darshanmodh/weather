package com.example.clearsky_boot.service;

import java.util.List;

import com.example.clearsky_boot.entity.AverageMatrix;
import com.example.clearsky_boot.entity.Weather;

public interface WeatherService {
	
	Weather create(Weather weather);
	
	List<String> findAllCities();
	
	Weather getWeatherByCity(String city);
	
	double getWeatherByCityAndProperty(String city, String prop);
	
	AverageMatrix getHourlyAverage(String city);
	
	AverageMatrix getDailyAverage(String city);

}
