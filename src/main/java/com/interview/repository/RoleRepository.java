package com.interview.repository;

import org.springframework.data.repository.Repository;

import com.interview.entity.Role;

public interface RoleRepository extends Repository<Role, Long>{
	
	public Role save(Role role);
	
	public Role findByRoleName(String roleName);
}
