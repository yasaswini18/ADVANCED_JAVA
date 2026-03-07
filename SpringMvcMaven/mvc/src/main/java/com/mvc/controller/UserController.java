package com.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.model.User;
import com.mvc.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/users")
	//@RequestMapping(value="/home",method=RequestMethod.GET)
	//request mapping is class level and method level
	public String listUsers(Model model)
	{
		model.addAttribute("users", userService.getAllUsers());
		return "userList";
	}
	
	@GetMapping("/addUser")
		public String showAddUserForm()
		{
			return "addUser";
		}
	
	@GetMapping("/user/{id}")
	public String getUser(@PathVariable Long id,Model model)
	{
		model.addAttribute("user",userService.getUserById(id));
		return "userDetail";
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestParam String name,@RequestParam String email)
	{
		//to accept the form data in key value pair- we use RequestParam
		Long newId = (long)(Math.random()*1000);
		userService.addUser(new User(newId,name,email));
		return "redirect:/users";
	}
	
}
