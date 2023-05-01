package com.demo.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name ="emp_salary")
public class EmployeeSalary {
	
	@Id
	@Column(name = "employeeid")
	private Integer employeeId;
	@Column(name = "accnumber")
	private String accountNumber;
	@Column(name = "accname")
	private String accountName;
	@Column(name = "salary")
	private Integer salary;

	
	@Transient
	private String code;
	@Transient
	private String message;
	
	public EmployeeSalary(String accountNumber,String accountName,Integer salary){
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.salary = salary;
	}

	public EmployeeSalary(){
		
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
//	public Employee getEmployee() {
//		return employee;
//	}
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
	

}
