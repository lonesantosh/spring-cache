package com.service;

import java.lang.classfile.ClassFile.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Actor;
import com.repo.IActorRepo;

@Service("ActorService")
public class IActorServiceImpl implements IActorService {
	
	@Autowired
	private IActorRepo repo;

	@Override
	public String registerActor(Actor actor) {
		Actor ac=repo.save(actor);
		return "Actor is saved with actor id "+ac.getActorId();
	}
	
	@Override
	public Iterable<Actor> fetchAllActor() {
		
		return repo.findAll();
	}
	
	@Override
	public String registerGroupsOfActor(List<Actor> list) {
		if(list!=null) {
			Iterable<Actor> obj=repo.saveAll(list);
			List<Integer> ids=new ArrayList();
			for(Actor ac:obj) {
				ids.add(ac.getActorId());
			}
			return ids.size()+" Objects are saved having id values "+ids;
		}else {
			return "problem in batch insertion";
		} 
	}
	
	@Override
	public boolean isExist(int id) {
		
		return repo.existsById(id);
	}
	@Override
	public long fetchCount() {
		
		return repo.count();
	}

	@Override
	public Actor showActorById(int id) {
	
		return repo.findById(id).orElseThrow(()-> new IllegalArgumentException("Actor not found"));
	}
	@Override
	public String updateActorMobileNo(int id, long mobNo) {
	
		Optional<Actor> opp=repo.findById(id);
		if(opp.isPresent()) {
			Actor ac=opp.get();
			ac.setMobNo(mobNo);
			repo.save(ac);
			return "Given id "+id+" mobile no is updated";
		}
		return "Given id is not found for update";
	}
	
	@Override
	public String removeActorById(int id) {
		Optional<Actor> pp=repo.findById(id);
		if(pp.isPresent()) {
			repo.deleteById(id);
		return "Gived id "+id+" record is deleted";
		}else {
			return id+" is not present for delete";
		}
			
	}
	@Override
	public String removeAll() {
		Long count=repo.count();
		repo.deleteAll();
		return count+ "records are deleted";
	}
	
}
