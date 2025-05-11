package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void deleteUser(String id) throws Exception {
			Optional<User> user1 = userRepository.findById(id);
			if(user1.isEmpty()) {
				throw new UserNotFoundException("User Not Found with id: "+id);
			}
			userRepository.deleteById(id);
	}

}
