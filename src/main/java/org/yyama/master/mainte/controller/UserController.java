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
import org.yyama.master.mainte.dto.UserFormDto;
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
	public String userEntry(@ModelAttribute UserFormDto userFormDto, Model model) throws SQLException {
		if (userFormDto.getName() == null) {
			model.addAttribute("userFormDto", userService.newUser());
		} else {
			model.addAttribute("userFormDto", userFormDto);
		}
		return "user-entry";
	}

	@PostMapping("/user/entry/confirm")
	public String userEntryConfirm(@Validated UserFormDto userFormDto, BindingResult result, Model model) {
		model.addAttribute("userFormDto", userFormDto);
		if (result.hasErrors()) {
			return "user-entry";
		}
		return "user-entry-confirm";
	}

	@PostMapping("/user/entry/complete")
	public String userEntryComplete(@ModelAttribute UserFormDto userFormDto, Model model) throws SQLException {
		userService.entry(userFormDto);
		return "redirect:/user/list";
	}

	@GetMapping("/user/modify")
	public String userModify(@ModelAttribute UserFormDto userFormDto, Model model) throws SQLException {
		if (userFormDto.getName() == null) {
			model.addAttribute("userFormDto", userService.getUserById(userFormDto.getId()));
		} else {
			model.addAttribute("userFormDto", userFormDto);
		}
		return "user-modify";
	}

	@PostMapping("/user/modify/confirm")
	public String userModifyConfirm(@Validated UserFormDto userFormDto , BindingResult result, Model model) {
		model.addAttribute("userFormDto", userFormDto);
		if (result.hasErrors()) {
			return "user-modify";
		}		
		return "user-modify-confirm";
	}

	@PostMapping("/user/modify/complete")
	public String userModifyComplete(@ModelAttribute UserFormDto userFormDto, Model model) throws SQLException {
		userService.modify(userFormDto);
		return "redirect:/user/list";
	}

	@GetMapping("/user/delete")
	public String userDelete(Model model, @RequestParam(name = "id") Long id) throws SQLException {
		model.addAttribute("user", userService.getUserById(id));
		return "user-delete-confirm";
	}

	@PostMapping("/user/delete/complete")
	public String userDeleteComplete(@ModelAttribute UserFormDto userFormDto, Model model) throws SQLException {
		userService.deleteUserById(userFormDto.getId());
		return "redirect:/user/list";
	}

}