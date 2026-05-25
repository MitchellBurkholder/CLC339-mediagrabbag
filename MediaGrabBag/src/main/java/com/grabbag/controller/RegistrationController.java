package com.grabbag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.grabbag.model.RegistrationModel;

import jakarta.validation.Valid;

// these annotations make the class a controller & gives it the mapping below
@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	//maps the url for the html page & setups model for data entry
	@GetMapping("/")
	public String displayRegisterForm(Model model) {
		model.addAttribute("title", "Registration Form");
		model.addAttribute("registrationModel", new RegistrationModel());
		return "Registration";
	}
	
	//process registration info
	@PostMapping("/doRegistration")
	public String completeRegistration(@Valid @ModelAttribute RegistrationModel registrationModel, BindingResult bindingResult, Model model ) {
		
		// checks for errors in data added
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Registration Form");
			return "Registration";
		}
		
		return "redirect:/login/";
	}
}
