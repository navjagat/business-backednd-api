package com.interview.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.interview.exception.DataNotFoundException;

@RestController
public abstract class BaseController {
	
	@ExceptionHandler(value=DataNotFoundException.class)
	public ResponseEntity<DataNotFoundException> raiseDataNotFoundException(DataNotFoundException ex){
		return new ResponseEntity<DataNotFoundException>(ex, HttpStatus.NO_CONTENT); 
	}
}
