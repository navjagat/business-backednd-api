package com.interview.repository;

import org.springframework.data.repository.Repository;

import com.interview.entity.UserConnection;

public interface UserConnectionRepository extends Repository<UserConnection, String> {
	
	public UserConnection save(UserConnection userConnection);
}
