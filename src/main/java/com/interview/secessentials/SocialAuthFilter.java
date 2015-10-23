package com.interview.secessentials;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.social.UserIdSource;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SocialAuthenticationServiceLocator;

public class SocialAuthFilter extends SocialAuthenticationFilter {

	public SocialAuthFilter(AuthenticationManager authenticationManager,
			UserIdSource userIdSource,
			UsersConnectionRepository usersConnectionRepository,
			SocialAuthenticationServiceLocator authServiceLocator) {
		super(authenticationManager, userIdSource, usersConnectionRepository, authServiceLocator);
	}

}
