package com.interview.repository;

import org.springframework.data.repository.Repository;

import com.interview.entity.User;

public interface UserRepository extends Repository<User, String> {
	
	public User findOne(String userId);
	
	public User save(User user);
}
