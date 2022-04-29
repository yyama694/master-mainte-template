package org.yyama.master.mainte;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {
	@GetMapping("/input")
	public String index(Model model) {
		model.addAttribute("msg", "Hello! Thymleaf!!");
		System.out.println("index!!!");
		return "index2";
	}
}