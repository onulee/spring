package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontController {

	@GetMapping({"/","/index"})
	public String index(Model model) {
		return "index";
	}
}
