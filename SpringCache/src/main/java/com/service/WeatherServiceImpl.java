package com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.model.Weather;
import com.repo.WeatherRepo;

@Service("weather")
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private WeatherRepo repo;
	
	
	public String saveWeatherDetails(Weather weather) {
		
		Weather wc=repo.save(weather);
		return "Register weather details with "+wc.getId();
	}
	
	/*@Override
	public String addGroupOfRecords(List<Weather> list) {
		if(list!=null) {
			Iterable<Weather> obj=repo.saveAll(list);
			List<Integer> ids=new ArrayList();
			for(Weather ac:obj) {
				ids.add(ac.getId());
			}
			return ids.size()+" Objects are saved having id values "+ids;
		}else {
			return "problem in batch insertion";
		} 
	}*/

	 @Override
	public Iterable<Weather> getWhetherDetails() {
		
		return repo.findAll();
	}
	 
	 @Override
	//CacheEvict(value="weather", key="#city")
	public String deleteById(int id) {
		 
		 Optional<Weather> opt=repo.findById(id);
		 if(opt.isPresent()) {
			 repo.delete(opt.get());
			 
			return id+" record is deleted";
	}else
	{
		return id+" records is not found";
		}
	}
	 
	 @Override
	//CachePut(value="weather", key="#city")
	public String updateWeather(Integer id, String city) {
	
		 Optional<Weather> opt1=repo.findById(id);
		 if(opt1.isPresent()) {
			 Weather w=opt1.get();
			 w.setCity(city);
			 repo.save(w);
			 return "Records is updated";
		 }else {
			 return "Records not updated";
		 }
	}
	 
	 @Override
	//Cacheable(value="weather", key="#city")
	public Weather getByCity(String city) {
		System.out.println("Weather data by city");
		return repo.findByCity(city);
	}
	 
	 @Override
	
	public String removeAll() {
		long count=repo.count();
		repo.deleteAll();
		return count+ " records are deleted";
	}
	 
}
