package com.prs.prsspringboot.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prs.prsspringboot.business.User;
import com.prs.prsspringboot.data.UserRepository;

@RestController
@RequestMapping("/users")

public class UserController {

	@Autowired
	private UserRepository userRepo;
	@CrossOrigin
	@PostMapping("/authenticate")
	public List<User> authenticate(@RequestBody User user) {
		 List<User> users = new ArrayList<User>();
		 
		 try {
			 Optional<User> result = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
			result.ifPresent(u -> users.add(u));
				 
			 
		 } catch (Exception e) {
			 System.out.println();
		 }
		 
		 
		 return users;
	}
	
	@GetMapping("/")
	public List<User> getAllUsers() {
		 List<User> users = new ArrayList<User>();
		
		try {
			Iterable<User> result = userRepo.findAll();
			result.forEach(u -> users.add(u));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	
		
		return users;
	}
	@CrossOrigin
	@GetMapping("/{id}")
	public List<User> getUserById(@PathVariable int id) {
		List<User> users = new ArrayList<User>();
		
		try {
			Optional<User> result = userRepo.findById(id);
			result.ifPresent(u -> users.add(u));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return users;
	}

	@CrossOrigin
	@PostMapping("")
	public List<User> createUser(@RequestBody User user){
		 List<User> users = new ArrayList<User>();
		 
		 try {
			 users.add(userRepo.save(user));
			 
		 } catch (DataIntegrityViolationException dive) {
			 System.out.println(dive.getMessage());
		 }
		 
		 return users;
	}
	@CrossOrigin
	@PutMapping("/{id}")
	public List<User> updateUser(@RequestBody User user, @PathVariable int id){
		List<User> users = new ArrayList<User>();
		
		
		if (userRepo.existsById(id)) {
			
			try {
				 users.add(userRepo.save(user));
			 } catch (DataIntegrityViolationException dive) {
				 System.out.println(dive.getMessage());
			 }
		}
		return users;
	}
	@CrossOrigin
		@DeleteMapping("/{id}")
		public List<User> deleteUser(@PathVariable int id){
			List<User> users = new ArrayList<User>();
			
			
			if (userRepo.existsById(id)) {
				
				try {
					Optional<User> result = userRepo.findById(id);
				if(result.isPresent());
					users.add(result.get());
					userRepo.deleteById(id);
				 } catch (Exception e) {
					 System.out.println(e.getMessage());
				 }
			}
			return users;
	}

	
	
	
	
	
}
