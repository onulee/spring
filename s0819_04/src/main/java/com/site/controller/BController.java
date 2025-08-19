package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
public class BController {

	// HttpServletRequest, @RequestParam , 객체타입, @PathVariable
	
	
	@GetMapping({"/board/blist/{page}","/board/blist"})
	public String blist(@PathVariable(value="page",required=false) Integer page, 
			Model model) {
		if(page == null) page=1;
		System.out.println("page : "+page);
		model.addAttribute("page",page);
		return "board/blist";
	}
	
	@GetMapping("/board/board")
	public String board(@RequestParam(defaultValue="1") String page,	
			Model model) {
		System.out.println("param page : "+page);
		model.addAttribute("page",page);
		return "board/blist";
	}
}
