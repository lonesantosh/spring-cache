package com.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.model.Actor;

public interface IActorPagingAndSorting extends PagingAndSortingRepository<Actor, Integer> {

}
