package com.demo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.entity.User;
import com.demo.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;
	@GetMapping(value = "/users")
	public Iterable<User> findAll(){
		return userservice.findAll();
	}
	
	@GetMapping(value = "/users/{id}")
	public User findById(@PathVariable Integer id){
		return userservice.findById(id);
	}
	@PostMapping(value = "/user")
	public User create(@RequestBody User user){
		return userservice.create(user);
		
	}
	@PutMapping(value = "/modifyuser")
	public User update(@RequestBody User user){
		return userservice.update(user);
	}
	@DeleteMapping(value = "/deleteuser/{id}")
	public User deleteById(@PathVariable Integer id){
		return userservice.deleteById(id);
	}
	
	@DeleteMapping(value = "/deleteAll")
	public User deleteAll(){
		return userservice.deleteAll();
	}
}
