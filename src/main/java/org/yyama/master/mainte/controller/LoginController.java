package org.yyama.master.mainte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.yyama.master.mainte.dto.LoginUserFormDto;


@Controller
public class LoginController {
	@GetMapping("/")
	public String loginRedirect() {
		return "redirect:/login";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/login/auth")
	public String loginAuth(LoginUserFormDto form) {
		System.out.println(form.getName());
		System.out.println(form.getPassword());
		return "main-menu";
	}
}
