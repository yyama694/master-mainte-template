package org.yyama.master.mainte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/top-menu")
	public String index(Model model) {
		model.addAttribute("msg", "Hello! Thymleaf!!");
		return "main-menu";
	}
}