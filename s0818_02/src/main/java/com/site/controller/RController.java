package com.site.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //문자열 리턴
public class RController {
	
	@GetMapping("/rest")
	public String restpage() {
		return "안녕하세요.";
	}

	
}
