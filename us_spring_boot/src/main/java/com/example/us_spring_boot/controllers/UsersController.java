package com.example.us_spring_boot.controllers;

import com.example.us_spring_boot.model.User;
import com.example.us_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/")
	public String printTable(Model model) {
		model.addAttribute("usertable", userService.findAllUsers());
		return "user_table";
	}

	@GetMapping(value = "/new")
	public String createUser(Model model) {
		model.addAttribute("user", new User());
		return "create";
	}

	@PostMapping("/new")
	public String create(@ModelAttribute("user") User user){
		userService.saveUser(user);
		return "redirect:/";
	}

	@GetMapping("/{id}/edit")
	public String updateUser(Model model, @PathVariable("id") int id) {
		model.addAttribute("user", userService.findUserById(id));
		return "edit";
	}

	@PatchMapping("/{id}/patch")
	public String update(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/";
	}

	@DeleteMapping("/{id}/delete/user")
	public String delete(@PathVariable("id") int id) {
		userService.removeUserById(id);
		return "redirect:/";
	}
}