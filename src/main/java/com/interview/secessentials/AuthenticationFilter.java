package com.interview.secessentials;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class AuthenticationFilter extends
		AbstractAuthenticationProcessingFilter {

private static final String USERNAME_PARAM = "username";
	
	private static final String PASSWORD_PARAM = "password";
	
	
	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		super(new AntPathRequestMatcher("/authentication/login", "POST"));
		setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException,
			IOException, ServletException {
		
		if(!request.getMethod().equalsIgnoreCase("POST"))
			throw new javax.security.sasl.AuthenticationException(
					"Authentication doesn't support: "+request.getMethod()+" Method");
		
		String username = request.getParameter(USERNAME_PARAM);
		String password = request.getParameter(PASSWORD_PARAM);
		
		UsernamePasswordAuthenticationToken authoken = 
				new UsernamePasswordAuthenticationToken(username, password);
		
		return getAuthenticationManager().authenticate(authoken);
	}

}
