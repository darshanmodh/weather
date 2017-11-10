package com.example.clearsky_boot.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.clearsky_boot.entity.AverageMatrix;
import com.example.clearsky_boot.entity.Weather;
import com.example.clearsky_boot.exception.BadRequestException;
import com.example.clearsky_boot.exception.NotFoundException;
import com.example.clearsky_boot.repository.WeatherRepository;
import com.example.clearsky_boot.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {
	
	private WeatherRepository repository;
	
	public WeatherServiceImpl(WeatherRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Weather create(Weather weather) {
		return repository.save(weather);
	}

	@Override
	public List<String> findAllCities() {
		return repository.findDistinctCity();
	}

	@Override
	public Weather getWeatherByCity(String city) {
		Optional<Weather> weather = repository.findFirstByCityOrderByTimestampDesc(city);
		if(!weather.isPresent())
			throw new NotFoundException(city + " has no record in system.");
		else
			return weather.get();
	}

	@Override
	public double getWeatherByCityAndProperty(String city, String prop) {
		Optional<Weather> weather = repository.findFirstByCityOrderByTimestampDesc(city);
		
		if(!weather.isPresent())
			throw new NotFoundException(city + " has no record in system.");
		
		switch(prop.toLowerCase()) {
			case "temperature":
				return weather.get().getTemperature();
			case "humidity":
				return weather.get().getHumidity();
			case "pressure":
				return weather.get().getPressure();
			default:
				throw new BadRequestException("Property is not recognized");
		}
	}

	@Override
	public AverageMatrix getHourlyAverage(String city) {
		int temperatureSum = 0;
		int humiditySum = 0;
		int pressureSum = 0;
		Date startTime = new Date(System.currentTimeMillis() - 3600 * 1000);
		Date endTime = new Date();
		List<Weather> list = repository.findByCityAndTimestampBetween(city, startTime, endTime);
		for(Weather w : list){
			temperatureSum += w.getTemperature();
			humiditySum += w.getHumidity();
			pressureSum += w.getPressure();
		}
		try {
			double temperatureAvg = temperatureSum / list.size();
			double humidityAvg = humiditySum / list.size();
			double pressureAvg = pressureSum / list.size();
			AverageMatrix averageMatrix = new AverageMatrix();
			averageMatrix.setCity(city);
			averageMatrix.setDescription("Hourly Average");
			averageMatrix.setHumidity(humidityAvg);
			averageMatrix.setPressure(pressureAvg);
			averageMatrix.setTemperature(temperatureAvg);
			return averageMatrix;
		} catch(Exception e) {
			throw new NotFoundException(city + " has no entry in system");
		}
	}

	@Override
	public AverageMatrix getDailyAverage(String city) {
		int temperatureSum = 0;
		int humiditySum = 0;
		int pressureSum = 0;
		Date startTime = new Date(System.currentTimeMillis() - 24 * 3600 * 1000);
		Date endTime = new Date();
		List<Weather> list = repository.findByCityAndTimestampBetween(city, startTime, endTime);
		for(Weather w : list){
			temperatureSum += w.getTemperature();
			humiditySum += w.getHumidity();
			pressureSum += w.getPressure();
		}
		try {
			double temperatureAvg = temperatureSum / list.size();
			double humidityAvg = humiditySum / list.size();
			double pressureAvg = pressureSum / list.size();
			AverageMatrix averageMatrix = new AverageMatrix();
			averageMatrix.setCity(city);
			averageMatrix.setDescription("Daily Average");
			averageMatrix.setHumidity(humidityAvg);
			averageMatrix.setPressure(pressureAvg);
			averageMatrix.setTemperature(temperatureAvg);
			return averageMatrix;
		} catch(Exception e) {
			throw new NotFoundException(city + " has no entry in system");
		}
	}

}
