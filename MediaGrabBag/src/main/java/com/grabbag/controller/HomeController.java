package com.grabbag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController
{
    @GetMapping("/")
    public String showHome()
    {
        return "home";
    }

    @GetMapping("/placeholder")
    public String showPlaceholder()
    {
        return "placeholder";
    }

    @GetMapping("/gotoregister")
    public String showRegistration()
    {
        return "Registration";
    }
}
