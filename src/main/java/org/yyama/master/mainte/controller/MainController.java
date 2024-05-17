package org.yyama.master.mainte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.yyama.master.mainte.domain.UserDomain;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@GetMapping("/top-menu")
	public String index(Model model, HttpSession session) {
		model.addAttribute("msg", "Hello! Thymleaf!!");
		System.out.println(session.getAttribute("user"));
		if (((UserDomain) session.getAttribute("user")).getAdministrator()) {
			model.addAttribute("isAdmin", "true");
		} else {
			model.addAttribute("isAdmin", "false");
		}
		return "main-menu";
	}
}