package com.example.PROJECT.Controller;

package com.example.PROJECT.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.PROJECT.Model.City;
import com.example.PROJECT.Model.Country;
import com.example.PROJECT.Model.Registration;
import com.example.PROJECT.Model.State;
import com.example.PROJECT.Service.CityService;
import com.example.PROJECT.Service.CountryService;
import com.example.PROJECT.Service.StateService;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {
	
	@Autowired
	private CountryService countryService;
		
	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}
	
	@Autowired
	private StateService stateService;
	
	public void setStateService(StateService stateService) {
		this.stateService = stateService;
	}
	
	@Autowired
	private CityService cityService;
	
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	@RequestMapping("/home")
	public String home(Model model) {
		return "Home";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		return "About";
	}
	
	@RequestMapping("/contact")
	public String contact(Model model) {
		return "Contact";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "Login";
	}
	
	@RequestMapping("/student")
	public String student(Model model) {
		return "Studentdashboard";
	}
	
	@RequestMapping("/registration")
	public String registration(Model model) {
		Registration registration = new Registration();
        model.addAttribute("registration", registration);  // Corrected attribute name
		model.addAttribute("countrylist", countryService.getCountries());
		return "Registration";
	}
	
	@RequestMapping("/state/{countryid}")
	public @ResponseBody Iterable<State> getStateByCountry(@PathVariable Country countryid) {
		return stateService.findCountry(countryid);
	}
	
	@RequestMapping("/city/{stateid}")
	public @ResponseBody List<City> getCityByState(@PathVariable State stateid) {
		return cityService.findCity(stateid);
	}
	
	@RequestMapping("/email")
	public String reg(Model model) { 
		model.addAttribute("usermodel", new Registration());
		return "Registration";
	}
}



