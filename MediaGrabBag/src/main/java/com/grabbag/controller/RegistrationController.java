package com.grabbag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grabbag.business.RegistrationServiceInterface;
import com.grabbag.model.RegistrationModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationServiceInterface registrationService;

    public RegistrationController(RegistrationServiceInterface registrationService) {
        this.registrationService = registrationService;
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

        return "redirect:/login/";
    }
}
