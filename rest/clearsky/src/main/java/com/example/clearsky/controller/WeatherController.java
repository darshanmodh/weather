package com.example.clearsky.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.clearsky.entity.Weather;
import com.example.clearsky.service.WeatherService;

@RestController
@RequestMapping(value = "/clearsky")
public class WeatherController {
	
	private WeatherService service;
	
	public WeatherController(WeatherService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Weather create(@RequestBody Weather weather) {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cities")
	public List<String> findAllCities() {
		return new ArrayList<>();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{city}")
	public Weather getWeatherByCity(@PathVariable("city") String city) {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{city}/{prop}")
	public Weather getWeatherByCityAndProperty(@PathVariable("city") String city, @PathVariable("prop") String prop) {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/hourlyavg/{city}")
	public Weather getHourlyAverage(@PathVariable("city") String city) {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/dailyavg/{city}")
	public Weather getDailyAverage(@PathVariable("city") String city) {
		return null;
	}

}
