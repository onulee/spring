package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FrontController {

	@GetMapping("/")
	public String index() {
		System.out.println("안녕하세요.");
		System.out.println("반가워요");
		return "index";
	}
}
