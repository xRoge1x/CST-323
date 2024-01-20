package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController
{
	
	@GetMapping("/")
	public String printHello(Model model) 
	{
		model.addAttribute("message", "Hello Spring MVC Framework");
		return "home";
	}
	
	
}
