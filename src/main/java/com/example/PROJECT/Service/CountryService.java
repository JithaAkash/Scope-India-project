package com.example.PROJECT.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepo;

	public void setCountryRepo(CountryRepository countryRepo) {
		this.countryRepo = countryRepo;
	}
	
	public List<Country> getCountries(){
		return countryRepo.findAll();
	}

}