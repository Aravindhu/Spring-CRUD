package com.demo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.entity.EmployeeSalary;
import com.demo.demo.service.EmployeeSalaryService;

@RestController
public class EmployeeSalaryController {
	@Autowired
	private EmployeeSalaryService salary;
	
	@GetMapping(value="/getAllSallary")
	public Iterable<EmployeeSalary> findALL(){
		return salary.findALL();
	}
	
	@PostMapping(value="/createSalary")
	public EmployeeSalary createSal(@RequestBody EmployeeSalary sal){
		return salary.createSalary(sal);
	}
	
	@PostMapping(value="/updateSalary")
	public EmployeeSalary updateSal(@RequestBody EmployeeSalary sal){
		return salary.updateSal(sal);
	}
	
	@DeleteMapping(value="/deleteAllSalary")
	public EmployeeSalary deleteAll(){
		return salary.deleteAll();
	}
	
	@DeleteMapping(value="/deleteById/{empId}")
	public EmployeeSalary deleteById(@PathVariable Integer empId){
		return salary.deleteById(empId);
	}
	
	@GetMapping(value="/findById/{empId}")
	public EmployeeSalary findById(@PathVariable Integer empId){
		return salary.findById(empId);
	}

}
