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
import org.yyama.master.mainte.dto.ItemFormDto;
import org.yyama.master.mainte.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	ItemService itemService;

	@GetMapping("/item/list")
	public String list(Model model) throws SQLException {
		model.addAttribute("items", itemService.getUsers());
		return "item-list";
	}

	@GetMapping("/item/detail")
	public String detail(Model model, @RequestParam Long id) throws SQLException {
		model.addAttribute("item", itemService.getItemById(id));
		return "item-detail";
	}

	@GetMapping("/item/entry")
	public String entry(@ModelAttribute ItemFormDto itemFormDto, Model model) throws SQLException {
		if (itemFormDto.getName() == null) {
			model.addAttribute("itemFormDto", itemService.newUser());
		} else {
			model.addAttribute("itemFormDto", itemFormDto);
		}
		return "item-entry";
	}

	@PostMapping("/item/entry/confirm")
	public String entryConfirm(@Validated ItemFormDto itemFormDto, BindingResult result, Model model) {
		model.addAttribute("itemFormDto", itemFormDto);
		if (result.hasErrors()) {
			return "item-entry";
		}
		return "item-entry-confirm";
	}

	@PostMapping("/item/entry/complete")
	public String entryComplete(@ModelAttribute ItemFormDto itemFormDto, Model model) throws SQLException {
		itemService.entry(itemFormDto);
		return "redirect:/item/list";
	}

	@GetMapping("/item/modify")
	public String modify(@ModelAttribute ItemFormDto itemFormDto, Model model) throws SQLException {
		if (itemFormDto.getName() == null) {
			model.addAttribute("itemFormDto", itemService.getItemById(itemFormDto.getId()));
		} else {
			model.addAttribute("itemFormDto", itemFormDto);
		}
		return "item-modify";
	}

	@PostMapping("/item/modify/confirm")
	public String modifyConfirm(@Validated ItemFormDto itemFormDto , BindingResult result, Model model) {
		model.addAttribute("itemFormDto", itemFormDto);
		if (result.hasErrors()) {
			return "item-modify";
		}		
		return "item-modify-confirm";
	}

	@PostMapping("/item/modify/complete")
	public String modifyComplete(@ModelAttribute ItemFormDto itemFormDto, Model model) throws SQLException {
		itemService.modify(itemFormDto);
		return "redirect:/item/list";
	}

	@GetMapping("/item/delete")
	public String delete(Model model, @RequestParam Long id) throws SQLException {
		model.addAttribute("item", itemService.getItemById(id));
		return "item-delete-confirm";
	}

	@PostMapping("/item/delete/complete")
	public String deleteComplete(@ModelAttribute ItemFormDto itemFormDto, Model model) throws SQLException {
		itemService.deleteItemById(itemFormDto.getId());
		return "redirect:/user/list";
	}

}