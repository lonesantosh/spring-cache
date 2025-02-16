package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Weather;
import com.repo.WeatherRepo;
import com.service.CacheInspectionManager;
import com.service.WeatherService;
import com.service.WeatherServiceImpl;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private WeatherService service;
	
	@Autowired
	private WeatherRepo rr;
	
	@Autowired
	private CacheInspectionManager CacheInspectionManager;
	
	@PostMapping("/save")
	public String saveDetails(@RequestBody Weather ww) {
		
		String msg=service.saveWeatherDetails(ww);
		
		return msg;
	}
	
	/*@PostMapping("/saveAll")
	public String saveGroupOfObjects(@RequestBody Weather ww) {
		
		String msg=service.saveWeatherDetails(ww);
		
		return msg;
	}*/
	
	@GetMapping("/get")
	public Iterable<Weather> getAllDetails(){
		
		return service.getWhetherDetails();
	}
	
	//localhost:8080/weather/data/Nanded  worked pass city in url
	
	@GetMapping("data/{city}")
	public Weather getWeatherDataByCity(@PathVariable String city) {
		System.out.println("Weather data");
		return service.getByCity(city);
	}
	
	//localhost:8080/weather/delete/45  worked
	@DeleteMapping("/delete/{id}")
	public String deleteRecordsById(@PathVariable("id") int id) {
		String res=service.deleteById(id);
		return res;
	}
	//localhost:8080/weather/update/43/Nanded  worked simply pass in request
	@PatchMapping("update/{id}/{city}")
	public String updateRecord(@PathVariable("id") Integer id,
								@PathVariable String city) {
		
		String mm=service.updateWeather(id, city);
		
		return mm;
		
	}
	
	//localhost:8080/weather/remove
	@DeleteMapping("/remove")
	public String deleteAllRecords() {
		return service.removeAll();
	}
}
