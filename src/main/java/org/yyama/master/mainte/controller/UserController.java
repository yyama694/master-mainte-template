package org.yyama.master.mainte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.yyama.master.mainte.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/user/list")
	public String user_list(Model model) {
		model.addAttribute("users", userService.getUsers());
		return "user-list";
	}

	@GetMapping("/user/detail")
	public String userDetail(Model model, @RequestParam(name = "id") Long id) {
		model.addAttribute("user", userService.getUserById(id));
		return "user-detail";
	}

	@PostMapping("/user/entry")
	public String userEntry(Model model) {
		return "user-entry";
	}

	@PostMapping("/user/entry/confirm")
	public String userEntryConfirm(Model model) {
		return "user-entry-confirm";
	}

	@GetMapping("/user/modify")
	public String userModify(Model model, @RequestParam(name = "id") Long id) {
		model.addAttribute("user", userService.getUserById(id));
		return "user-modify";
	}

	@PostMapping("/user/modify/confirm")
	public String userModifyConfirm(Model model) {
		return "user-modify-confirm";
	}
	
	@GetMapping("/user/delete")
	public String userDelete(Model model, @RequestParam(name = "id") Long id) {
		userService.deleteUserById(id);
		return "redirect:/user/list";
	}

}