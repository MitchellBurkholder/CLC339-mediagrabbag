package com.grabbag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grabbag.model.LoginModel;

@Controller
@RequestMapping("/mediagrabbag.com/login")
public class LoginController {
	
	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	@PostMapping("/loginSuccess")
	public String doLogin(LoginModel loginModel, BindingResult bindingResult, Model model) {
			return "home";
	}
}
