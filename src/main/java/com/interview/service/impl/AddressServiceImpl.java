/**
 * 
 */
package com.interview.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.interview.entity.Address;
import com.interview.exception.DataNotFoundException;
import com.interview.exception.ErrorCode;
import com.interview.repository.AddressRepository;
import com.interview.service.AddressService;

/**
 * @author navneet.prabhakar
 *
 */
public class AddressServiceImpl implements AddressService {

	private AddressRepository repository;

	public AddressServiceImpl(AddressRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Address create(Address address) {
		return repository.save(address);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Address> retrieveAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public Address update(Address address) throws DataNotFoundException {
		Address add = repository.findOne(address.getId());

		if (add == null)
			throw new DataNotFoundException("No Address Found for Id: "
					+ address.getId(), ErrorCode.NO_DATA);

		return repository.save(address);
	}

	@Override
	@Transactional
	public void remove(Long id) throws DataNotFoundException {
		Address add = repository.findOne(id);

		if (add == null)
			throw new DataNotFoundException("No Address Found for Id: " + id,
					ErrorCode.NO_DATA);

		repository.delete(id);

	}

}
