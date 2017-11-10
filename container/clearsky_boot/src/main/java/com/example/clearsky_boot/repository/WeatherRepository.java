package com.example.clearsky_boot.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.example.clearsky_boot.entity.Weather;

public interface WeatherRepository extends Repository<Weather, String> {
	
	public Weather save(Weather weather);
	
	@Query("SELECT DISTINCT w.city FROM Weather w")
	public List<String> findDistinctCity();
	
	public Optional<Weather> findFirstByCityOrderByTimestampDesc(String city);
	
	public List<Weather> findByCityAndTimestampBetween(String city, Date startTime, Date endTime); 

}
