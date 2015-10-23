package com.interview.service.impl;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.interview.entity.UserConnection;
import com.interview.service.impl.UserServiceImpl.CustomUserDetails;

public class SocialUserService implements SocialUserDetailsService {
	
	private UserDetailsService userDetailsService;
	
	public SocialUserService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	public SocialUserDetails loadUserByUserId(String userId)
			throws UsernameNotFoundException, DataAccessException {
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
		
		return new CustomSocialUserDetails(userDetails); 
	}
	
	private static class CustomSocialUserDetails extends UserConnection implements SocialUserDetails{
		private static final long serialVersionUID = 1L;
		
		private UserDetails userDetails;
		
		public CustomSocialUserDetails(UserDetails userDetails) {
			CustomUserDetails det = (CustomUserDetails) userDetails;
			setDisplayName(det.getFirstName() + " " + det.getLastName());
			setImageUrl(det.getAvatar());
			this.userDetails = userDetails;
		}
		
		@Override
		@JsonIgnore
		public boolean isEnabled() {
			return false;
		}
		
		@Override
		@JsonIgnore
		public boolean isCredentialsNonExpired() {
			return false;
		}
		
		@Override
		@JsonIgnore
		public boolean isAccountNonLocked() {
			return false;
		}
		
		@Override
		@JsonIgnore
		public boolean isAccountNonExpired() {
			return false;
		}
		
		@Override
		public String getUsername() {
			return ((CustomUserDetails) userDetails).getEmail();
		}
		
		@Override
		@JsonIgnore
		public String getPassword() {
			return userDetails.getPassword();
		}
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return userDetails.getAuthorities();
		}
		
		@Override
		public String getUserId() {
			return userDetails.getUsername();
		}
	}
	
	

}
