/**
 * 
 */
package com.interview.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.interview.entity.Business;
import com.interview.exception.DataNotFoundException;
import com.interview.service.BusinessService;

/**
 * @author navneet.prabhakar
 *
 */
@RestController
@RequestMapping(value="/business", produces=MediaType.APPLICATION_JSON_VALUE)
public class BusinessController extends BaseController{
	
	private BusinessService businessService;

	/**
	 * Sets the Business service
	 * @param businessService the businessService to set
	 */
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	@RequestMapping(value="", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Business create(@RequestBody Business business){
		return businessService.create(business);
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Business update(@RequestBody Business business) throws DataNotFoundException{
		return businessService.update(business);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Business> retrieveAll(){
		return businessService.retrieveAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) throws DataNotFoundException{
		businessService.remove(id);
	}
		
}
