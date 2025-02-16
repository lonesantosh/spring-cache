package com.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.Employee;
import com.service.IEmpServiceImpl;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	 private IEmpServiceImpl service;
	
	@GetMapping("/")
	public String showHomePage() {
		return "Home";
	}
		@GetMapping("/get")
	public  String   showEmployeeReport(Map<String,Object> map) {
		
		Iterable<Employee> emp=service.getAllEmployees();
		//keep results as model attribute
		map.put("empsData", emp);
		return "Employee_report";
	}
		 @GetMapping("/add")
	 public  String   showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		   //return LNV
		return "Employee_register";
	}
	 	    @PostMapping("/add")
	   public  String insertEmployee(RedirectAttributes attrs,
				@ModelAttribute("emp")Employee emp) {
			//use service
			String result=service.addEmployee(emp);
			//add result to model attribute 
		    attrs.addFlashAttribute("resultMsg",result);
			//retunr LVN
			return "redirect:get";
			}
	
	@GetMapping("/edit")
	public String   showEditEmployeeFormPage(@RequestParam("no") int no, @ModelAttribute("emp") Employee emp) {
		//use serivce
		Employee emp1=service.getEmployeeByEno(no);
		BeanUtils.copyProperties(emp1, emp);
		//return  lvn
		return  "Employee_edit";
	}
	
	@PostMapping("/edit")
	public  String  editEmployee(RedirectAttributes attrs ,@RequestParam("no") int no,
			                                               @ModelAttribute("emp") Employee emp) {
		//use service
		String result=service.updateEmployee(emp);
		//keep results in model attributes
		attrs.addFlashAttribute("resultMsg", result);
		//return LVN
		return "redirect:get";
	}
	
	@GetMapping("/delete")
	public   String deleteEmployee(@RequestParam("no") int no, 
			                                                          RedirectAttributes attrs) {
		//use service
		String result=service.deleteEmployeeByEno(no);
		//keep results in model attributes
		attrs.addFlashAttribute("resultMsg", result);
		//return LVN
		return "redirect:get";
	}

}