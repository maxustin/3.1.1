package com.example.us_spring_boot.controllers;

import com.example.us_spring_boot.model.User;
import com.example.us_spring_boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

	private UserService userService;

	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String printTable(Model model) {
		model.addAttribute("usertable", userService.getAllUsersFromDatabase());
		return "user_table";
	}

	@GetMapping(value = "/new")
	public String createUser(Model model) {
		model.addAttribute("user", new User());
		return "create";
	}

	@PostMapping("/new")
	public String create(@ModelAttribute("user") User user){
		userService.addUserToDatabase(user);
		return "redirect:/";
	}

	@GetMapping("/{id}/edit")
	public String updateUser(Model model, @PathVariable("id") int id) {
		model.addAttribute("user", userService.getUserByIdFromDatabase(id));
		return "edit";
	}

	@PatchMapping("/{id}/patch")
	public String update(@ModelAttribute("user") User user) {
		userService.updateUserInDatabase(user);
		return "redirect:/";
	}

	@DeleteMapping("/{id}/delete/user")
	public String delete(@PathVariable("id") int id) {
		userService.removeUserByIdFromDatabase(id);
		return "redirect:/";
	}
}