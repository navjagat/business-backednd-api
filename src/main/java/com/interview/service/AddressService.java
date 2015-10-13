/**
 * 
 */
package com.interview.service;

import java.util.List;

import com.interview.entity.Address;
import com.interview.exception.DataNotFoundException;

/**
 * @author navneet.prabhakar
 *
 */
public interface AddressService {
	
	public Address create(Address address);
	
	public List<Address> retrieveAll();
	
	public Address update(Address address) throws DataNotFoundException;
	
	public void remove(Long id) throws DataNotFoundException;
}
