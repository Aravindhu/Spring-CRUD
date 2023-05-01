package com.demo.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.demo.entity.EmployeeSalary;

@Repository
public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalary, Integer>{

	@Query("select sal from EmployeeSalary as sal where accountNumber =:accNumber ")
	Optional<EmployeeSalary> findAccNo(@Param("accNumber") String accountNumber);

}
