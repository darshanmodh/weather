package com.example.clearsky.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.clearsky.entity.Weather;
import com.example.clearsky.repository.WeatherRepository;
import com.example.clearsky.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {
	
	private WeatherRepository repository;
	
	public WeatherServiceImpl(WeatherRepository repository) {
		this.repository = repository;
	}

	@Override
	public Weather create(Weather weather) {
		return null;
	}

	@Override
	public List<String> findAllCities() {
		return null;
	}

	@Override
	public Weather getWeatherByCity(String city) {
		return null;
	}

	@Override
	public Weather getWeatherByCityAndProperty(String city, String prop) {
		return null;
	}

	@Override
	public Weather getHourlyAverage(String city) {
		return null;
	}

	@Override
	public Weather getDailyAverage(String city) {
		return null;
	}

}
