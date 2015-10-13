/**
 * 
 */
package com.interview.service;

import java.util.List;

import com.interview.entity.Business;
import com.interview.exception.DataNotFoundException;

/**
 * @author MRAMALTI
 *
 */
public interface BusinessService {
	
	public Business create(Business business);
	
	public Business update(Business business) throws DataNotFoundException;
	
	public void remove(Long id) throws DataNotFoundException;
	
	public List<Business> retrieveAll();
	
}
