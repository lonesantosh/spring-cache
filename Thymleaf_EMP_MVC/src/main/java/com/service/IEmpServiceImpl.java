package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.model.Employee;
import com.repo.IEmployeeRepo;

@Service("empService")
public class IEmpServiceImpl  implements IEMPService {
	@Autowired
    private  IEmployeeRepo  empRepo;
	
	@Override
	public Iterable<Employee> getAllEmployees() {
		
		return empRepo.findAll();
	}

	@Override
	public String addEmployee(Employee emp) {
		return "Employee is saved"+empRepo.save(emp);
	}

	@Override
	public Employee getEmployeeByEno(int eno) {
		
		Employee obj=empRepo.findById(eno).get();
		return obj;
	}
	
	@Override
	public String updateEmployee(Employee emp) {
		
		int id=empRepo.save(emp).getEmpno();
		return id+" Employee is updated";
		//return  empRepo.save(emp).getEmpno()+" Employee updated";
	}
	
	@Override
	public String deleteEmployeeByEno(int eno) {
		empRepo.deleteById(eno);
		return eno+"  employee number  Employee deleted";
	}

}