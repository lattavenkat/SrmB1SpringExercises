package com.org.srm.jwt.service;

import java.util.List;

import javax.transaction.Transactional;

import com.org.srm.jwt.model.Country;
import com.org.srm.jwt.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryRepository repo;

	@Override
	public List<Country> getCountries() {
		return repo.findAll();
	}

}
