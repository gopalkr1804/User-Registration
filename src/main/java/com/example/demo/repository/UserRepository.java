package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	Optional<User> findById(String id);
}
