package org.yyama.master.mainte.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	public String user_list(Model model) throws SQLException {
		model.addAttribute("users", userService.getUsers());
		return "user-list";
	}

	@GetMapping("/user/detail")
	public String userDetail(Model model, @RequestParam(name = "id") Long id) throws SQLException {
		model.addAttribute("user", userService.getUserById(id));
		return "user-detail";
	}

	@GetMapping("/user/entry")
	public String userEntry(@ModelAttribute UserDomain userDomain, Model model) throws SQLException {
		if (userDomain.getName() == null) {
			model.addAttribute("userDomain", userService.newUser());
		} else {
			model.addAttribute("userDomain", userDomain);
		}
		return "user-entry";
	}

	@PostMapping("/user/entry/confirm")
	public String userEntryConfirm(@Validated UserDomain userDomain, BindingResult result, Model model) {
		model.addAttribute("userDomain", userDomain);
		if (result.hasErrors()) {
			return "user-entry";
		}
		return "user-entry-confirm";
	}

	@PostMapping("/user/entry/complete")
	public String userEntryComplete(@ModelAttribute UserDomain user, Model model) throws SQLException {
		userService.entryComplete(user);
		return "redirect:/user/list";
	}

	@GetMapping("/user/modify")
	public String userModify(@ModelAttribute UserDomain userDomain, Model model) throws SQLException {
		if (userDomain.getName() == null) {
			model.addAttribute("userDomain", userService.getUserById(userDomain.getId()));
		} else {
			model.addAttribute("userDomain", userDomain);
		}
		return "user-modify";
	}

	@PostMapping("/user/modify/confirm")
	public String userModifyConfirm(@Validated UserDomain userDomain, BindingResult result, Model model) {
		model.addAttribute("userDomain", userDomain);
		if (result.hasErrors()) {
			return "user-modify";
		}		
		return "user-modify-confirm";
	}

	@PostMapping("/user/modify/complete")
	public String userModifyComplete(@ModelAttribute UserDomain userDomain, Model model) throws SQLException {
		userService.modify(userDomain);
		return "redirect:/user/list";
	}

	@GetMapping("/user/delete")
	public String userDelete(Model model, @RequestParam(name = "id") Long id) throws SQLException {
		model.addAttribute("user", userService.getUserById(id));
		return "user-delete-confirm";
	}

	@PostMapping("/user/delete/complete")
	public String userDeleteComplete(@ModelAttribute UserDomain user, Model model) throws SQLException {
		userService.deleteUserById(user.getId());
		return "redirect:/user/list";
	}

}