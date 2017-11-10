package com.example.clearsky_boot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Weather")
public class AverageMatrix {
	
	@Id
	private String weatherId;
	private String city;
	private String description;
	private double pressure;
	private double temperature;
	private double humidity;


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

	@Override
	public String toString() {
		return "AverageMatrix [city=" + city + ", description=" + description + ", pressure=" + pressure
				+ ", temperature=" + temperature + ", humidity=" + humidity + "]";
	}

}
