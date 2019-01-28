package com.utc.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.utc.entities.User;
import com.utc.services.UserService;

@RestController
@RequestMapping(UserController.path)
public class UserController {

	static final String path = "/user";

	private UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(User user) {
		return new ResponseEntity<>(service.createUser(user), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAllUsers(User user) {
		return new ResponseEntity<>(service.findAllUsers(), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	public ResponseEntity<User> findUserByEmail(@PathVariable("email") String email) {
		return new ResponseEntity<>(service.findUserByEmail(email), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> deleteUserById(String _id) {
		return new ResponseEntity<>(service.deleteUserById(new ObjectId(_id)), HttpStatus.ACCEPTED);
	}
}
