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
import com.grabbag.business.RegistrationServiceInterface;
import com.grabbag.model.RegistrationModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationServiceInterface registrationService;
    private LoginInterface loginService;
    
    // constructor needed for this controller 
    public RegistrationController(RegistrationServiceInterface registrationService, LoginInterface loginService) {
        this.registrationService = registrationService;
        this.loginService = loginService;
    }

    @GetMapping("/")
    public String displayRegisterForm(Model model) {
        model.addAttribute("title", "Registration Form");
        model.addAttribute("registrationModel", new RegistrationModel());
        return "Registration";
    }

    @PostMapping("/doRegistration")
    public String completeRegistration(
            @Valid @ModelAttribute("registrationModel") RegistrationModel registrationModel,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Registration Form");
            return "Registration";
        }

        registrationService.registerUser(registrationModel);
        // this is here so the login info can be added to the database 
        loginService.create(registrationModel.getUsername(), registrationModel.getPassword());

        return "redirect:/login/";
    }
}
