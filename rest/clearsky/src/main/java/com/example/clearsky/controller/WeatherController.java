package com.example.clearsky.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.clearsky.entity.Weather;
import com.example.clearsky.service.WeatherService;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {
	
	private WeatherService service;
	
	public WeatherController(WeatherService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Weather create(@RequestBody Weather weather) {
		return service.create(weather);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cities")
	public List<String> findAllCities() {
		return service.findAllCities();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{city}")
	public Weather getWeatherByCity(@PathVariable("city") String city) {
		return service.getWeatherByCity(city);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{city}/{prop}")
	public double getWeatherByCityAndProperty(@PathVariable("city") String city, @PathVariable("prop") String prop) {
		return service.getWeatherByCityAndProperty(city, prop);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/hourlyavg/{city}")
	public Weather getHourlyAverage(@PathVariable("city") String city) {
		return service.getHourlyAverage(city);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/dailyavg/{city}")
	public Weather getDailyAverage(@PathVariable("city") String city) {
		return service.getDailyAverage(city);
	}

}
