package com.example.clearsky.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.clearsky.entity.Weather;
import com.example.clearsky.exception.BadRequestException;
import com.example.clearsky.repository.WeatherRepository;
import com.example.clearsky.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {
	
	private WeatherRepository repository;
	
	public WeatherServiceImpl(WeatherRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Weather create(Weather weather) {
		return repository.create(weather);
	}

	@Override
	public List<String> findAllCities() {
		return repository.findAllCities();
	}

	@Override
	public Weather getWeatherByCity(String city) {
		Weather weather = repository.getWeatherByCity(city);
		if(weather == null)
			throw new BadRequestException(city + " has no record in system.");
		else
			return weather;
	}

	@Override
	public double getWeatherByCityAndProperty(String city, String prop) {
		Weather weather = repository.getWeatherByCity(city);
		switch(prop.toLowerCase()) {
			case "temperature":
				return weather.getTemperature();
			case "humidity":
				return weather.getHumidity();
			case "pressure":
				return weather.getPressure();
			default:
				throw new BadRequestException(city + " has no record in system.");
		}
	}

	@Override
	public Weather getHourlyAverage(String city) {
		int temperatureSum = 0;
		int humiditySum = 0;
		int pressureSum = 0;
		Date startTime = new Date(System.currentTimeMillis() - 3600 * 1000);
		Date endTime = new Date();
		List<Weather> list = repository.getHourlyAverage(city, startTime, endTime);
		for(Weather w : list){
			temperatureSum += w.getTemperature();
			humiditySum += w.getHumidity();
			pressureSum += w.getPressure();
		}
		double temperatureAvg = temperatureSum / list.size();
		double humidityAvg = humiditySum / list.size();
		double pressureAvg = pressureSum / list.size();
		Weather weatherMatrix = new Weather();
		weatherMatrix.setCity(city);
		weatherMatrix.setDescription("Hourly Average");
		weatherMatrix.setHumidity(humidityAvg);
		weatherMatrix.setPressure(pressureAvg);
		weatherMatrix.setTemperature(temperatureAvg);
		return weatherMatrix;
	}

	@Override
	public Weather getDailyAverage(String city) {
		int temperatureSum = 0;
		int humiditySum = 0;
		int pressureSum = 0;
		Date startTime = new Date(System.currentTimeMillis() - 24 * 3600 * 1000);
		Date endTime = new Date();
		List<Weather> list = repository.getDailyAverage(city, startTime, endTime);
		for(Weather w : list){
			temperatureSum += w.getTemperature();
			humiditySum += w.getHumidity();
			pressureSum += w.getPressure();
		}
		double temperatureAvg = temperatureSum / list.size();
		double humidityAvg = humiditySum / list.size();
		double pressureAvg = pressureSum / list.size();
		Weather weatherMatrix = new Weather();
		weatherMatrix.setCity(city);
		weatherMatrix.setDescription("Daily Average");
		weatherMatrix.setHumidity(humidityAvg);
		weatherMatrix.setPressure(pressureAvg);
		weatherMatrix.setTemperature(temperatureAvg);
		return weatherMatrix;
	}

}
