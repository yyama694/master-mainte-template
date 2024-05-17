package org.yyama.master.mainte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.yyama.master.mainte.dto.LoginUserFormDto;
import org.yyama.master.mainte.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class LoginController {
	@Autowired
	LoginService loginService;

	@GetMapping("/")
	public String loginRedirect() {
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login/auth")
	public String loginAuth(LoginUserFormDto dto, HttpServletRequest request) throws Exception {
		if (loginService.loginAuth(dto, request)) {
			return "redirect:/top-menu";
		}
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		loginService.logout(request);
		return "login";
	}

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

}
