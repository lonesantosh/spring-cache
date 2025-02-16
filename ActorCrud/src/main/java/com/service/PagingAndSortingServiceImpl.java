package com.service;

import java.awt.print.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.model.Actor;
import com.repo.IActorPagingAndSorting;

@Service("PagingService")
public class PagingAndSortingServiceImpl implements PagingAndSortingService {

	@Autowired
	private IActorPagingAndSorting repo;
	
	@Override
	public Page<Actor> showPageByPageSize(int pageNo, int pazeSize) {
		
		org.springframework.data.domain.Pageable pageable=PageRequest.of(pageNo, pazeSize);
		Page<Actor> pg=repo.findAll(pageable);
		return pg;
	}
	
	@Override
	public void showActorByPageSize(int pageSize) {
		long recordsCounts=repo.count();
		long pageRecords=recordsCounts/pageSize;
		
		pageRecords=(recordsCounts%pageSize==0)?pageRecords:++pageRecords;
		
		for(int i=0;i<pageRecords;i++) {
			org.springframework.data.domain.Pageable page=PageRequest.of(i, pageSize);
			Page<Actor> pg=repo.findAll(page);
			System.out.println((i+1)+" page records");
			
			pg.getContent().forEach(System.out::println);
		}
		
	}
}
