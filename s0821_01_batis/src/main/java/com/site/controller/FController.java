package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FController {

	@GetMapping("/")
	public String index(
			@RequestParam(name="flag",required = false) String flag,
			Model model) {
		model.addAttribute("flag",flag); //있을때 1, 없을때 null
		System.out.println("index flag : "+flag);
		return "index";
	}
}
