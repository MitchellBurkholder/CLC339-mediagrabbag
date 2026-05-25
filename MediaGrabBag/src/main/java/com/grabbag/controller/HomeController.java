package com.grabbag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController
{
	//maps the home page
    @GetMapping("/")
    public String showHome()
    {
        return "Home";
    }

    //needed for placeholder page to appear 
    @GetMapping("/placeholder")
    public String showPlaceholder()
    {
        return "Placeholder";
    }
}
