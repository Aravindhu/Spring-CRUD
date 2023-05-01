package com.demo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.entity.Employee;
import com.demo.demo.entity.EmployeeDetails;
import com.demo.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping(value = "/emplyees")
	public Iterable<Employee> findAll(){
		return employeeservice.findAll();
	}
	
	@GetMapping(value = "/emplyees/{empcode}")
	public Employee findById(@PathVariable Integer empcode ){
		return employeeservice.findById(empcode);
		
	}
	
	@PostMapping(value = "/createemployee")
	public Employee createEmployee(@RequestBody Employee emp){
		return employeeservice.createEmployee(emp);
	}
	
	@PostMapping(value = "/updateemployee")
	public Employee update(@RequestBody Employee emp){
		return employeeservice.update(emp);
	}
	
	@DeleteMapping(value = "/deleteemployee/{empcode}")
	public Employee deleteById(@PathVariable Integer empcode ){
		return employeeservice.deleteById(empcode);
		
	}
	
	@DeleteMapping(value = "/deleteemployee")
	public Employee deleteAll(){
		return employeeservice.deleteAll();
		
	}
	
	@GetMapping(value = "/getEmpSal/{empcode}")
	public EmployeeDetails getEmpSal(@PathVariable Integer empcode ){
		return employeeservice.getEmpSal(empcode);
		
	}
	
	
}