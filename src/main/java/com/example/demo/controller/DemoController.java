package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.User;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;

@RestController
public class DemoController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;

	@GetMapping("/check")
	public String controllerSample() {
		return "Calling controller";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDto getUser(@PathVariable String id) {
		UserDto user = new UserDto();
		Optional<User> user1 = userRepository.findById(id);
		if(user1.isEmpty()) {
			throw new UserNotFoundException("User Not Found");
		}
		else {
			user.setId(user1.get().getId());
			user.setName(user1.get().getName());
			user.setPhone(user1.get().getPhone());
			user.setEmail(user1.get().getEmail());
		}
		
		return user;
	}
	
	@PostMapping(value = "/createUser")
	public ResponseEntity<String> createUser(@RequestBody UserDto user){
		User user1 = new User();
		user1.setId(user.getId());
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		user1.setPhone(user.getPhone());
		try {
			userRepository.save(user1);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error saving user", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("User created successfully with ID: " + user1.getId(), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id){
		try {
			userService.deleteUser(id);
		}
		catch(UserNotFoundException unfe){
			throw new UserNotFoundException("User Not Found with ID: "+ id);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error deleting user", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>("User deleted successfully with ID: "+ id, HttpStatus.OK);
	}


	

}
