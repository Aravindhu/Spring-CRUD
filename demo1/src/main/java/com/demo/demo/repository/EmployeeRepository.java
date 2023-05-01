package com.demo.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.demo.entity.Employee;
import com.demo.demo.entity.EmployeeDetails;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select employee from Employee as employee where emailId =:emailid")
	Optional<Employee> findByMailId(@Param("emailid") String emailId);

	@Query("select new com.demo.demo.entity.EmployeeDetails(emp.employeeCode ,emp.firstName ,emp.lastName,sal.accountName,sal.accountNumber,sal.salary,emp.addresss,emp.phoneNumber,emp.emailId,emp.pinCode) from Employee as emp inner join EmployeeSalary as sal on sal.employeeId = emp.employeeCode  where  emp.employeeCode =:empid ")
	Optional<EmployeeDetails> findSalaryById(@Param("empid") Integer empcode);

}
