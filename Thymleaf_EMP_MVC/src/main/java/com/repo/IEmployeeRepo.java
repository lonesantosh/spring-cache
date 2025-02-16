package com.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.model.Employee;

public interface IEmployeeRepo extends PagingAndSortingRepository<Employee,Integer> {

}