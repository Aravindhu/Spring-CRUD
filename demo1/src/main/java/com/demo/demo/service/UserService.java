package com.demo.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.demo.entity.User;
import com.demo.demo.repository.UserRepository;

@Service
public class UserService {
@Autowired
private UserRepository userrepository;
	public Iterable<User> findAll() {
		return userrepository.findAll();
	}
	public User create(User user) {
		User u =new User();
		Optional<User> optional =userrepository.findbyEmail(user.getEmailId());
		if(!optional.isPresent()){
			userrepository.save(user);
			user.setCode("0000");
			user.setMessage("Successfully Created User Details...");
			return user;
		}else{
			u.setCode("9999");
			u.setMessage("Already Created Email address...");
			return u;
		}
		
	}
	public User update(User user) {
		if(user.getUserId() != null){
			Optional<User> optional =userrepository.findById(user.getUserId());
			if(optional.isPresent()){
				User updateUser =optional.get();
				updateUser.setUserId(user.getUserId());
				updateUser.setFirstName(user.getFirstName());
				updateUser.setLastName(user.getLastName());
				updateUser.setEmailId(user.getEmailId());
				userrepository.save(updateUser);
				updateUser.setCode("0000");
				updateUser.setMessage("Successfully Updated User Details...");
				return updateUser;
			}else{
				user.setCode("9999");
				user.setMessage("User detail not found...");
				return user;
			}
		}else{
			user.setCode("9999");
			user.setMessage("User detail not found...");
			return user;
		}
		
	}
	public User deleteById(Integer id) {
		User user1 = new User();
			Optional<User> optional =userrepository.findById(id);
			if(optional.isPresent()){
				
				userrepository.deleteById(optional.get().getUserId());
				user1.setCode("0000");
				user1.setMessage("Successfully deleted User Details...");
				return user1;
			}else{
				user1.setCode("9999");
				user1.setMessage("User detail not found...");
				return user1;
			}
		
	}

	public User deleteAll() {
		userrepository.deleteAll();
		User u =new User();
		u.setCode("0000");
		u.setMessage("User detail deleted sucessfully...");
		return u;
	}
	public User findById(Integer id) {
		Optional<User> optional =userrepository.findById(id);
		if(optional.isPresent()){
			optional.get().setCode("0000");
			optional.get().setMessage("sucessfully retrived user details...");
			return  optional.get();

		}
		return null;
	}

}
