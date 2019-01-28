package com.utc.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utc.entities.User;
import com.utc.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository repository;

	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public List<User> findAllUsers() {
		return repository.findAll();
	}

	public User createUser(User user) {
		return repository.save(user);
	}

	public User findUserByEmail(String email) {
		return repository.findByEmail(email);
	}

	public User deleteUserById(ObjectId _id) {
		return repository.deleteById(_id);
	}

}
