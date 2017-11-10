package com.example.clearsky_boot.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Weather {
	
	@Id
	private String weatherId;
	private String city;
	private String description;
	private double pressure;
	private double temperature;
	private double humidity;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Wind wind;

	private Date timestamp;
	
	public Weather() {
		this.weatherId = UUID.randomUUID().toString();
	}

	public String getWeatherId() {
		return weatherId;
	}

	public void setWeatherId(String weatherId) {
		this.weatherId = weatherId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Weather [weatherId=" + weatherId + ", city=" + city + ", description=" + description + ", pressure="
				+ pressure + ", temperature=" + temperature + ", humidity=" + humidity + ", wind=" + wind
				+ ", timestamp=" + timestamp + "]";
	}

}
