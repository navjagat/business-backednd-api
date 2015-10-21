package com.interview.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.interview.entity.User;

@RestController
@RequestMapping(value="/authentication", produces=MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public User getAuthentication(Authentication authentication){
		if(authentication != null){
			
			return (User) authentication.getPrincipal();
		}else
			return null;
	}
	
	/*@RequestMapping(value="/google", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void getGoogleAuthentication(){
		
	}*/

}
