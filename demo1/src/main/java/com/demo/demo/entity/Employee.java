package com.demo.demo.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "employee_detail")
public class Employee{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO , generator ="employee_detail")
	@SequenceGenerator(name="employee_detail" , sequenceName="employee_detail_empcode" ,allocationSize = 1)
	@Column(name = "empcode")
	private Integer employeeCode;
	@Column(name = "firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;

	@Column(name="address",columnDefinition ="text")
	private String addresss;
	@Column(name="phonenumber")
	private BigInteger phoneNumber;
	@Column(name="emailid")
	private String emailId;
	@Column(name="pincode")
	private String pinCode;
	@Column(name="isnewuser")
	private Boolean isnewuser;
		
	@Transient
	private String code;
	@Transient
	private String message;
	
	
	
	public Employee(Integer employeeCode,String firstName,String lastName,String accountName,String accountNumber,Integer salary,String addresss,BigInteger phoneNumber,String emailId,String pinCode){
		
//		super(accountNumber,accountName,salary);
		this.employeeCode = employeeCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addresss = addresss;
		this.phoneNumber= phoneNumber;
		this.emailId = emailId;
		this.pinCode = pinCode;
		
		
		
	}
	
	
	public Boolean getIsnewuser() {
		return isnewuser;
	}
	public void setIsnewuser(Boolean isnewuser) {
		this.isnewuser = isnewuser;
	}
	public Employee() {
		super();
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
	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
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
	
	
	

}
