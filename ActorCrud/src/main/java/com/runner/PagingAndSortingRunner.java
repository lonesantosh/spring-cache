package com.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.model.Actor;
import com.service.PagingAndSortingService;
@Component
public class PagingAndSortingRunner implements CommandLineRunner {

	@Autowired
	 private PagingAndSortingService service;
	@Override
	public void run(String... args) throws Exception {
		
		Page<Actor> page=service.showPageByPageSize(0, 4);
		/*
		List<Actor> list=page.getContent();
		list.forEach(System.out::println);
		System.out.println("Current page info in number "+page.getNumber());
		System.out.println("Total pages "+page.getTotalPages());
		System.out.println("How many pages "+page.getNumberOfElements());
		System.out.println("Is it first page "+page.isFirst());
		System.out.println("Is it last page "+page.isLast());
		System.out.println("No of records in DB table "+page.getTotalElements());*/
		
		service.showActorByPageSize(3);
		
	}
}
