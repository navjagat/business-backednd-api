/**
 * 
 */
package com.interview.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.interview.entity.Business;

/**
 * This class Stores the {@link Business} in Database
 * 
 * @author navneet.prabhakar
 * @since 12 October 2015
 * @version 1.0
 */
public interface BusinessRepository extends CrudRepository<Business, Long> {
	
	public List<Business> findAll();
	
}
