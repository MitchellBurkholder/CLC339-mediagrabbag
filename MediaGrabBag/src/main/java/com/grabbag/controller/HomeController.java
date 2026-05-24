package com.grabbag.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController
{
    @GetMapping("/")
    public String printHome()
    {
        return "home";
    }
}
