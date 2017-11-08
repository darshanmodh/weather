package com.example.clearsky.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.clearsky.entity.Weather;
import com.example.clearsky.repository.WeatherRepository;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Weather create(Weather weather) {
		em.persist(weather);
		return weather;
	}

	@Override
	public List<String> findAllCities() {
		TypedQuery<String> query = em.createNamedQuery("Weather.findAllCities", String.class);
		return query.getResultList();
	}

	@Override
	public Weather getWeatherByCity(String city) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.getWeatherByCity", Weather.class);
		query.setParameter("city", city);
		List<Weather> list = query.setMaxResults(1).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list.get(0);
	}

//	@Override
//	public int getWeatherByCityAndProperty(String city, String prop) {
//		TypedQuery<Integer> query = null;
//		List<Integer> list = new ArrayList<Integer>();
//		switch(prop) {
//			case "temperature":
//				query = em.createNamedQuery("Weather.getTemperatureByCity", Integer.class);
//				query.setParameter("city", city);
//				break;
//			case "humidity":
//				query = em.createNamedQuery("Weather.getHumidityByCity", Integer.class);
//				query.setParameter("city", city);
//				break;
//			case "pressure":
//				query = em.createNamedQuery("Weather.getPressureByCity", Integer.class);
//				query.setParameter("city", city);
//				break;
//			default:
//				list = query.setMaxResults(1).getResultList();
//		}
//		return list.isEmpty() ? 0 :list.get(0); 
//	}

	@Override
	public List<Weather> getHourlyAverage(String city, Date startTime, Date endTime) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.getWeatherOfPast", Weather.class);
		query.setParameter("city", city);
		query.setParameter("startTime", startTime);
		query.setParameter("endTime", endTime);
		return query.getResultList();
	}

	@Override
	public List<Weather> getDailyAverage(String city, Date startTime, Date endTime) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.getWeatherOfPast", Weather.class);
		query.setParameter("city", city);
		query.setParameter("startTime", startTime);
		query.setParameter("endTime", endTime);
		return query.getResultList();
	}

}
