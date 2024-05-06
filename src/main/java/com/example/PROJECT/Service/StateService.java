package com.example.PROJECT.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepo;

	public void setStateRepo(StateRepository stateRepo) {
		this.stateRepo = stateRepo;
	}
	
	public List<State> findCountry(Country countryid){
		return stateRepo.findByCountry(countryid);
	}
	
	public List<State> getStates(){
		return stateRepo.findAll();
	}
	

	 
}