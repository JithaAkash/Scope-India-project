package com.example.PROJECT.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepo;

	public void setCityRepo(CityRepository cityRepo) {
		this.cityRepo = cityRepo;
	}
	
	public List<City> findCity(State stateid){
		return cityRepo.findByState(stateid);
	}
	 
}
