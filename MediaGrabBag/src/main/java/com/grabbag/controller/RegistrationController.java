package com.grabbag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.grabbag.model.RegistrationModel;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@GetMapping("/")
	public String displayRegisterForm(Model model) {
		model.addAttribute("title", "Registration Form");
		model.addAttribute("Registration Model", new RegistrationModel());
		return "register";
	}
	
	@GetMapping("/doRegistration")
	public String completeRegistration(RegistrationModel registerModel, BindingResult bindingResult, Model model ) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Registration Form");
			return "register";
		}
		
		return "login";
	}
}
