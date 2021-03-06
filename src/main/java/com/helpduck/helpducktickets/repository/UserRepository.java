package com.helpduck.helpducktickets.repository;

import java.util.Optional;

import com.helpduck.helpducktickets.entity.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
  Optional<User> findByEmail(String email);
}