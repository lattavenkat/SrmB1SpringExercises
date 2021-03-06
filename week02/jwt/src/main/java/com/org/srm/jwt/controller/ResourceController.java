package com.org.srm.jwt.controller;

import java.util.List;

import com.org.srm.jwt.model.Country;
import com.org.srm.jwt.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ResourceController extends BaseController {
	
	@Autowired
	private CountryService service;
	
	//@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/hellouser")
	public String getUser()
	{
		return "Hello User";
	}
	
	//@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/helloadmin", method = RequestMethod.GET)
	public String getAdmin()
	{
		return "Hello Admin";
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/countries")
	public List<Country> getCountries()
	{
		System.out.println(this.getUserContext());
		return service.getCountries();
	}
	
	
}
