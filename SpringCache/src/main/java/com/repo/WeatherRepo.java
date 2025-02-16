package com.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Weather;

public interface WeatherRepo extends JpaRepository<Weather, Integer>{
	
	Weather findByCity(String city);

}
