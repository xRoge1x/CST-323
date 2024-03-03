package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.LoggerComponent.LoggerInterceptor;

import org.slf4j.event.Level;

@Controller
@RequestMapping("/")
public class HomeController {

	private LoggerInterceptor loggerInterceptor;
	
	public HomeController(LoggerInterceptor loggerInterceptor) {
        this.loggerInterceptor = loggerInterceptor;
    }
	
    @GetMapping("/")
    public String home(Model model) {
    	// Logging logic for home page displayed
    	loggerInterceptor.log(Level.INFO, HomeController.class.getName(), "home", "Displaying home page");
        
        return "home";
    }
}