package com.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Weather {
	
	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	private Integer Id;
	
	private String city;
	
	private String forecast;

}
