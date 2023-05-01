package com.demo.demo.entity;

import java.math.BigInteger;

public class EmployeeDetails {

	private Integer employeeCode;
	private String firstName;
	private String lastName;
	private String addresss;
	private String emailId;
	private BigInteger phoneNumber;
	private String pinCode;
	private String accountName;
	private String accountNumber;
	private Integer salary;
	private String code;
	private String message;

	public EmployeeDetails(Integer employeeCode,String firstName,String lastName,String accountName,String accountNumber,Integer salary,String addresss,BigInteger phoneNumber,String emailId,String pinCode){
		this.employeeCode = employeeCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.salary = salary;
		this.addresss = addresss;
		this.phoneNumber= phoneNumber;
		this.emailId = emailId;
		this.pinCode = pinCode;
	}
	
	public EmployeeDetails(){
		
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

	public Integer getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(Integer employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddresss() {
		return addresss;
	}

	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [employeeCode=" + employeeCode + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", addresss=" + addresss + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber + ", pinCode="
				+ pinCode + ", accountName=" + accountName + ", accountNumber=" + accountNumber + ", salary=" + salary
				+ "]";
	}
}
