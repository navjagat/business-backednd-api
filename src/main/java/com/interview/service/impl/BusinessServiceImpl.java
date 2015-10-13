/**
 * 
 */
package com.interview.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.interview.entity.Business;
import com.interview.exception.DataNotFoundException;
import com.interview.exception.ErrorCode;
import com.interview.repository.BusinessRepository;
import com.interview.service.BusinessService;

/**
 * @author navneet.prabhakar
 *
 */
public class BusinessServiceImpl implements BusinessService {

	private BusinessRepository repository;
	
	public BusinessServiceImpl(BusinessRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Business create(Business business) {
		return repository.save(business);
	}

	@Override
	@Transactional
	public Business update(Business business) throws DataNotFoundException {
		Business buss = repository.findOne(business.getId());

		if (buss == null)
			throw new DataNotFoundException("No Data for Id: "
					+ business.getId(), ErrorCode.NO_DATA);

		return repository.save(business);
	}

	@Override
	@Transactional
	public void remove(Long id) throws DataNotFoundException {
		Business buss = repository.findOne(id);

		if (buss == null)
			throw new DataNotFoundException("No Data for Id: "
					+ id, ErrorCode.NO_DATA);

		repository.delete(id);

	}

	@Override
	@Transactional(readOnly=true)
	public List<Business> retrieveAll() {
		return repository.findAll();
	}

}
