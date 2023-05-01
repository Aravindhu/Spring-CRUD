package com.demo.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.demo.entity.EmployeeSalary;
import com.demo.demo.repository.EmployeeSalaryRepository;

@Service
public class EmployeeSalaryService {

	@Autowired
	private EmployeeSalaryRepository salaryrepository;
	
	public Iterable<EmployeeSalary> findALL() {
		return salaryrepository.findAll();
	}

	public EmployeeSalary createSalary(EmployeeSalary sal) {

			Optional<EmployeeSalary> optional = salaryrepository.findAccNo(sal.getAccountNumber());
			if(optional.isPresent()){
				sal.setCode("9999");
				sal.setMessage("Account Number already exist..");
				return sal;
			}else{
				salaryrepository.save(sal);
				sal.setCode("0000");
				sal.setMessage("Successfully save ...");
				return sal;
			}
		
		
	}

	public EmployeeSalary updateSal(EmployeeSalary sal) {
		
		Optional<EmployeeSalary> optional = salaryrepository.findById(sal.getEmployeeId());
		if(optional.isPresent()){
			EmployeeSalary salary = optional.get();
			salary.setAccountName(sal.getAccountName());
			salary.setAccountNumber(sal.getAccountNumber());
			salary.setSalary(sal.getSalary());
			salaryrepository.save(salary);
			salary.setCode("0000");
			salary.setMessage("Successfully updated salary detail..");
			return salary;
		}else{
			sal.setCode("9999");
			sal.setMessage("No valid detail found ...");
			return sal;
		}
	}

	public EmployeeSalary deleteAll() {
		salaryrepository.deleteAll();
		EmployeeSalary salary =  new EmployeeSalary();
		salary.setCode("0000");
		salary.setMessage("Successfully deleted ...");
		
		return salary;
	}

	public EmployeeSalary deleteById(Integer empId) {
		EmployeeSalary salary =  new EmployeeSalary();
		Optional<EmployeeSalary> optional = salaryrepository.findById(empId);
		if(optional.isPresent()){
			salaryrepository.deleteById(empId);
			salary.setCode("0000");
			salary.setMessage("Successfully deleted salary detail..");
			return salary;
		}else{
			salary.setCode("9999");
			salary.setMessage("No valid detail found ...");
			return salary;
		}
	}
	
	public EmployeeSalary findById(Integer empId) {
		EmployeeSalary salary =  new EmployeeSalary();
		Optional<EmployeeSalary> optional = salaryrepository.findById(empId);
		if(optional.isPresent()){
			
			return optional.get();
		}else{
			salary.setCode("9999");
			salary.setMessage("No valid detail found ...");
			return salary;
		}
	}

}
