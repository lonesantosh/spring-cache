package com.service;

import org.springframework.data.domain.Page;

import com.model.Actor;

public interface PagingAndSortingService {
	
	public Page<Actor> showPageByPageSize(int pageNo,int pazeSize);
	public void showActorByPageSize(int pageSize);
}
