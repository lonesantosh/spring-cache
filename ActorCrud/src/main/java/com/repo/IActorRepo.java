package com.repo;

import org.springframework.data.repository.CrudRepository;

import com.model.Actor;

public interface IActorRepo extends CrudRepository<Actor, Integer> {

}
