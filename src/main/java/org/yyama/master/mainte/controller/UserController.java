package org.yyama.master.mainte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	@GetMapping("/user/list")
	public String user_list(Model model) {
		return "user-list";
	}
	@PostMapping("/user/detail")
	public String userDetail(Model model) {
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
	@PostMapping("/user/modify")
	public String userModify(Model model) {
		return "user-modify";
	}
	@PostMapping("/user/modify/confirm")
	public String userModifyConfirm(Model model) {
		return "user-modify-confirm";
	}
}