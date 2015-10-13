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

import com.interview.entity.Address;
import com.interview.exception.DataNotFoundException;
import com.interview.service.AddressService;

/**
 * @author navneet.prabhakar
 *
 */
@RestController
@RequestMapping(value="/address", consumes=MediaType.APPLICATION_JSON_VALUE)
public class AddressController extends BaseController {
	
	private AddressService addressService;

	/**
	 * Sets the {@link AddressService} for the controller
	 * 
	 * @param addressService the addressService to set
	 */
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@RequestMapping(value="", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Address create(@RequestBody Address address){
		return addressService.create(address);
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Address update(@RequestBody Address address) throws DataNotFoundException{
		return addressService.update(address);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Address> retrieveAll(){
		return addressService.retrieveAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) throws DataNotFoundException{
		addressService.remove(id);
	}
	
}
