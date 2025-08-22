package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BController {

	@GetMapping("/board/bList")
	public String bList() {
		return "board/bList";
	}
}
