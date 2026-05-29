package com.grabbag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grabbag.business.LoginInterface;
import com.grabbag.model.LoginModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {
	//@autowired
	
	@Autowired
	LoginInterface loginService;
	
	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "Login";
	}
	
	// process login info, the valid & modelAttribute annotations ensure the errors messages appear
	@PostMapping("/doLogin")
	public String doLogin(@Valid @ModelAttribute LoginModel loginModel, BindingResult bindingResult, Model model) {
		
		if(!loginService.authenticate(loginModel.getUsername(), loginModel.getPassword())) {
			model.addAttribute("title", "Login Form");
			return "Login";
		}
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "Login";
		}
			return "redirect:/";
	}
}
