package com.utc.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.utc.entities.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);

	User deleteById(ObjectId _id);

}
