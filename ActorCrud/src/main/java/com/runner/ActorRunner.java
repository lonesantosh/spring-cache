package com.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.model.Actor;
import com.service.IActorService;
@Component
public class ActorRunner implements CommandLineRunner {

	@Autowired
	private IActorService service;
	@Override
	public void run(String... args) throws Exception {
		
		/*Actor aa=new Actor();
		aa.setAName("Sanjay");
		aa.setACity("Nanded");
		aa.setMobNo(7387808382l);
		System.out.println(service.registerActor(aa));
		
		//System.out.println(service.fetchAllActor());
		
		List<Actor> data=List.of(new Actor(105,"Rohit","Hingoli",781422l),
								new Actor(106,"Virat","Delhi",987569l),
								new Actor(107,"Shami","kolkata",777888l));
		System.out.println(service.registerGroupsOfActor(data));
		*/
		
		//System.out.println(service.isExist(104));
		//System.out.println(service.fetchCount());
		//System.out.println(service.showActorById(103));
		//System.out.println(service.fetchAllActor());
		//System.out.println(service.updateActorMobileNo(105,777777l));
		//System.out.println(service.removeActorById(107));
		//System.out.println(service.fetchAllActor());
		//System.out.println(service.removeAll());
	}
	
}
