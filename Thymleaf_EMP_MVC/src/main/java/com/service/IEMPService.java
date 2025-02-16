package com.service;

import java.util.List;

import com.model.Employee;

public interface IEMPService {
     public   Iterable<Employee>  getAllEmployees();
     public   String   addEmployee(Employee emp);
     public  Employee  getEmployeeByEno(int eno);
    public  String    updateEmployee(Employee emp);   
    public  String    deleteEmployeeByEno(int eno);
}