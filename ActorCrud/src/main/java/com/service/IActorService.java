package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Actor;

public interface IActorService {

	public String registerActor(Actor actor);
	public String registerGroupsOfActor(List<Actor> list);
	public boolean isExist(int id);
	public long fetchCount();
	
	public Iterable<Actor> fetchAllActor();
	public Actor showActorById(int id);
	
	public String updateActorMobileNo(int id ,long mobNo);
	public String removeActorById(int id);
	public String removeAll();
}
