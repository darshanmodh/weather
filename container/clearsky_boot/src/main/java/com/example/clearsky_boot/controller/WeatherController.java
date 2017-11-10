package com.example.clearsky_boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.clearsky_boot.entity.AverageMatrix;
import com.example.clearsky_boot.entity.Weather;
import com.example.clearsky_boot.service.WeatherService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/weather")
@Api(tags="weather")
public class WeatherController {
	
	private WeatherService service;
	
	public WeatherController(WeatherService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Create a new weather entry", notes = "Returns newly crerated weather entry")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 400, message = "Bad Request")
	})
	public Weather create(@RequestBody Weather weather) {
		return service.create(weather);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cities")
	@ApiOperation(value = "Find all cities", notes = "Returns list of all cities in system")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public List<String> findAllCities() {
		return service.findAllCities();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{city}")
	@ApiOperation(value = "Find latest weather of given city", notes = "Returns latest weather of given city")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")
	})
	public Weather getWeatherByCity(@PathVariable("city") String city) {
		return service.getWeatherByCity(city);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{city}/{prop}")
	@ApiOperation(value = "Find specific property of given city", notes = "Returns value of provided property and city")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")
	})
	public double getWeatherByCityAndProperty(@PathVariable("city") String city, @PathVariable("prop") String prop) {
		return service.getWeatherByCityAndProperty(city, prop);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/hourlyavg/{city}")
	@ApiOperation(value = "Find average values on hourly basis", notes = "Returns hourly average of temperature, humidity and pressure for given city")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")
	})
	public AverageMatrix getHourlyAverage(@PathVariable("city") String city) {
		return service.getHourlyAverage(city);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/dailyavg/{city}")
	@ApiOperation(value = "Find average values on daily basis", notes = "Returns daily average of temperature, humidity and pressure for given city")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")
	})
	public AverageMatrix getDailyAverage(@PathVariable("city") String city) {
		return service.getDailyAverage(city);
	}

}
