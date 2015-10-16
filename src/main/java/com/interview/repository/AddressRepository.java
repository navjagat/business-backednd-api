/**
 * 
 */
package com.interview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.interview.entity.Address;
import com.interview.entity.Business;

/**
 * Stores {@link Address} of any {@link Business}es in Database 
 * 
 * @author navneet.prabhakar
 * @since 12 October 2015
 * @version 1.0
 */
public interface AddressRepository extends CrudRepository<Address, Long> {

	public List<Address> findAll();
	
	@Query("From #{entityName} a Where (a.lat >= ?1 and a.lng >= ?2) and (a.lat <= ?3 && a.lng <= ?4")
	public List<Address> getFilteredData(double latMin, double lngMin, double latMax, double lngMax);
	
}
