package com.demo.demo.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.demo.demo.entity.Employee;
import com.demo.demo.entity.EmployeeDetails;
import com.demo.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeerepo;
	
	@Autowired
    private JavaMailSender mailSender;
	
	public Iterable<Employee> findAll() {
		return employeerepo.findAll();
	}

	public Employee findById(Integer empcode) {
		Employee emp = new Employee();
		Optional<Employee> optional = employeerepo.findById(empcode);
		if(optional.isPresent()){
			Employee emp1 = optional.get();
			emp1.setCode("0000");
			emp1.setMessage("Successfully retrived employee detail....");
			return emp1;
		}else{
			emp.setCode("9999");
			emp.setMessage("No Data Retrived...");
			return emp;

		}
	}

	public Employee createEmployee(Employee emp) {

		Optional<Employee> optional = employeerepo.findByMailId(emp.getEmailId());
		if(optional.isPresent()){
			Employee emp1 = new Employee();
			emp1.setCode("9999");
			emp1.setMessage("Emailid already exist....");
			return emp1;
		}else{
			emp.setIsnewuser(true);
			Employee employee = employeerepo.save(emp);
			
			StringBuilder subject = new StringBuilder();
			subject.append("Hello "+employee.getFirstName()+" "+employee.getLastName()+" use the following credential...");
			subject.append("\n Username : "+employee.getFirstName());
			subject.append("\n Password : "+getPassword());
			subject.append("\n EmailId : "+employee.getEmailId());
			
			SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(employee.getEmailId());
	        message.setSubject("Use the credential for login ");
	        message.setText(subject.toString());
	        
	        mailSender.send(message);
			
			emp.setCode("0000");
			emp.setMessage("Successfully created employee detail....");
			return emp;

		}
		
	}

	private String getPassword() {

		Random random = new Random();
		long randomNumber = random.nextInt(10000000);
		if(randomNumber < 0){
			randomNumber = randomNumber * -1 ;
		   }
		
		String pwd =""+randomNumber+randomNumber;
		if(pwd.length()>5){
			return pwd.substring(0,5);

		}else{
			randomNumber = randomNumber*111;
			pwd +=randomNumber;
			return pwd.substring(0,5);
		}
	}

	public Employee update(Employee emp) {
		if(emp.getEmployeeCode() != null){
			Optional<Employee> optional = employeerepo.findById(emp.getEmployeeCode());
			if(optional.isPresent()){
				Employee emp1 = optional.get();
				emp1.setFirstName(emp.getFirstName());
				emp1.setLastName(emp.getLastName());
				emp1.setAddresss(emp.getAddresss());
				emp1.setPhoneNumber(emp.getPhoneNumber());
				emp1.setPinCode(emp.getPinCode());
				employeerepo.save(emp1);
				emp1.setCode("0000");
				emp1.setMessage("Successfully updated employee detail....");
				return emp1;
			}else{
				
				emp.setCode("9999");
				emp.setMessage("No valid data found ...");
				return emp;

			}
		}else{
			emp.setCode("9999");
			emp.setMessage("No valid data found ...");
			return emp;
		}
		
	}

	public Employee deleteById(Integer empcode) {
		Employee emp = new Employee();
		Optional<Employee> optional = employeerepo.findById(empcode);
		if(optional.isPresent()){
			employeerepo.deleteById(empcode);
			emp.setCode("0000");
			emp.setMessage("Successfully deleted employee detail");
			return emp;
		}else{
			emp.setCode("9999");
			emp.setMessage("No valid data found ...");
			return emp;
		}
		
	}

	public Employee deleteAll() {
		Employee emp = new Employee();
		employeerepo.deleteAll();
		emp.setCode("0000");
		emp.setMessage("Successfully deleted employee detail...");
		return emp;
	}

	public EmployeeDetails getEmpSal(Integer empcode) {
		if(empcode != null){
			Optional<EmployeeDetails> optional = employeerepo.findSalaryById(empcode);
			if(optional.isPresent()){
				return optional.get();
			}else{
				EmployeeDetails empdet = new EmployeeDetails();
				empdet.setCode("9999");
				empdet.setMessage("No valid data found ...");
				return empdet;
			}
		}
		return null;
	}

}
