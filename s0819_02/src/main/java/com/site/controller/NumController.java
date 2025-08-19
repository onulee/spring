package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class NumController {

	@GetMapping("/num/numInput")
	public String numInput() {
		return "num/numInput";
	}
	
	@PostMapping("/num/numInput")
	public String numInput( HttpServletRequest request,
			@RequestParam("name") String name,
			@RequestParam("kor") int kor,
			@RequestParam("eng") int eng,
			Model model) {
//		String name = request.getParameter("name");
//		int kor = Integer.parseInt(request.getParameter("kor"));
//		int eng = Integer.parseInt(request.getParameter("eng"));
		int total = kor + eng;
		
		model.addAttribute("name",name);
		model.addAttribute("kor",kor);
		model.addAttribute("eng",eng);
		model.addAttribute("total",total);
		
		
		
		return "num/numResult";
	}
}
