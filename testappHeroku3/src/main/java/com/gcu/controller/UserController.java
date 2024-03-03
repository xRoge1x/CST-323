package com.gcu.controller;

import com.gcu.LoggerComponent.LoggerInterceptor;
import com.gcu.model.User;
import com.gcu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.event.Level;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private LoggerInterceptor loggerInterceptor;
	
    @Autowired
    private UserRepository userRepository;
    
    public UserController(LoggerInterceptor loggerInterceptor) {
        this.loggerInterceptor = loggerInterceptor;
    }
    
    @GetMapping("/form")
    public String userForm(Model model) {
    	loggerInterceptor.log(Level.INFO, UserController.class.getName(), "userForm", "Displaying user form");
        
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
    	// Saving log logic
        loggerInterceptor.log(Level.INFO, UserController.class.getName(), "saveUser", "Saving user");
        
        userRepository.save(user);
        return "redirect:/users/list";
    }

    @GetMapping("/list")
    public String userList(Model model) {
    	// Retrieving user list logic
        loggerInterceptor.log(Level.INFO, UserController.class.getName(), "userList", "Displaying user list");
        
        model.addAttribute("users", userRepository.findAll());
        return "userList";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
    	// Edit user logic
        loggerInterceptor.log(Level.INFO, UserController.class.getName(), "editUser", "Editing user with ID: " + id);
        
        User user = userRepository.findById(id).orElse(null);
        model.addAttribute("user", user);
        return "userForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
    	// Delete user logic
        loggerInterceptor.log(Level.INFO, UserController.class.getName(), "deleteUser", "Deleting user with ID: " + id);
        
        userRepository.deleteById(id);
        return "redirect:/users/list";
    }
}
