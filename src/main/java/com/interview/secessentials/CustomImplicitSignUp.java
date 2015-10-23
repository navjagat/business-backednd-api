package com.interview.secessentials;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

import com.interview.entity.Role;
import com.interview.entity.User;
import com.interview.repository.RoleRepository;
import com.interview.repository.UserConnectionRepository;
import com.interview.repository.UserRepository;

public class CustomImplicitSignUp implements ConnectionSignUp {
	
	
	@SuppressWarnings("unused")
	private UserConnectionRepository repository;
	
	private UserRepository userRepository;
	
	private RoleRepository roleRepository;

	public CustomImplicitSignUp(UserConnectionRepository repository) {
		this.repository = repository;
	}

	@Override
	public String execute(Connection<?> connection) {
		UserProfile profile = connection.fetchUserProfile();
		
			User user = new User(profile.getUsername(), profile.getEmail(), RandomStringUtils.randomAlphanumeric(8), profile.getFirstName(), profile.getLastName(), connection.getImageUrl());
			//TODO: assign roles according to provider
			Role role;
			List<Role> roles = new ArrayList<Role>();
			if(roleRepository != null){
				role = roleRepository.findByRoleName("ROLE_USER");
				if(role == null){
					role = new Role();
					role.setRoleName("ROLE_USER");
					role = roleRepository.save(role);
					roles.add(role);
				}
				roles.add(role);
			}
			
			user.setRoles(roles);
			
			return userRepository.save(user).getUserId();

	}

	/**
	 * @param userRepository the userRepository to set
	 */
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * @param roleRepository the roleRepository to set
	 */
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

}
