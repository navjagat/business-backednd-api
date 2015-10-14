package com.interview.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.interview.entity.Role;
import com.interview.entity.User;
import com.interview.repository.UserRepository;

public class UserServiceImpl implements UserDetailsService {

	private UserRepository repository;
	
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = repository.findOne(username);
		
		if(user == null)
			throw new UsernameNotFoundException("No user Found for Id: "+username);
		
		user.getRoles().size();
		return new CustomUserDetails(user);
	}
	
	public static class CustomUserDetails extends User implements UserDetails {
		
		private static final long serialVersionUID = 1L;

		public CustomUserDetails(User user) {
			super(user);
		}
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			List<Role> roles = getRoles();
			String[] rolesString = new String[roles.size()];
			Integer i = 0;
			
			for(Role role : roles){
				rolesString[i] = role.getRoleName();
				i++;
			}
			
			return AuthorityUtils.createAuthorityList(rolesString);
		}

		@Override
		public String getPassword() {
			return getPass();
		}

		@Override
		public String getUsername() {
			return getUserId();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

	}

}
