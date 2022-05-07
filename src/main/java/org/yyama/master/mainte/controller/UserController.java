package org.yyama.master.mainte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.yyama.master.mainte.domain.UserDomain;
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

	@GetMapping("/user/entry")
	public String userEntry(@ModelAttribute UserDomain user, Model model) {
		if (user.getName() == null) {
			model.addAttribute("user", userService.newUser());
		} else {
			model.addAttribute("user", user);
		}
		return "user-entry";
	}

	@PostMapping("/user/entry/confirm")
	public String userEntryConfirm(@ModelAttribute UserDomain user, Model model) {
		model.addAttribute("user", user);
		return "user-entry-confirm";
	}

	@PostMapping("/user/entry/complete")
	public String userEntryComplete(@ModelAttribute UserDomain user, Model model) {
		userService.entryComplete(user);
		return "redirect:/user/list";
	}

	@GetMapping("/user/modify")
	public String userModify(@ModelAttribute UserDomain user, Model model) {
		if (user.getName() == null) {
			model.addAttribute("user", userService.getUserById(user.getId()));
		} else {
			model.addAttribute("user", user);
		}
		return "user-modify";
	}

	@PostMapping("/user/modify/confirm")
	public String userModifyConfirm(@ModelAttribute UserDomain user, Model model) {
		model.addAttribute("user", user);
		return "user-modify-confirm";
	}

	@PostMapping("/user/modify/complete")
	public String userModifyComplete(@ModelAttribute UserDomain user, Model model) {
		userService.modify(user);
		return "redirect:/user/list";
	}

	@GetMapping("/user/delete")
	public String userDelete(Model model, @RequestParam(name = "id") Long id) {
		model.addAttribute("user", userService.getUserById(id));
		return "user-delete-confirm";
	}

	@PostMapping("/user/delete/complete")
	public String userDeleteComplete(@ModelAttribute UserDomain user, Model model) {
		userService.deleteUserById(user.getId());
		return "redirect:/user/list";
	}

}