package com.service;

import java.util.Iterator;
import java.util.List;

import com.model.Weather;

public interface WeatherService {
	
	public String saveWeatherDetails(Weather weather);
	
	//public String addGroupOfRecords(List<Weather> weather);
	public Iterable<Weather> getWhetherDetails();
	//public Weather getWeatherByCity(String city);
	
	public String deleteById(int id);
	public String updateWeather(Integer id,String city);
	
	public Weather getByCity(String city);
	
	public String removeAll();

}
