package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.site.dto.Num;

@Controller
public class NumController {

	@GetMapping("/num/num")
	public String numInput() {
		return "num/numInput";
	}
	
	@PostMapping("/num/num")
	public String numInput(Num num, Model model) {
		//num.setTotal(num.getKor()+num.getEng()); // kor,eng -> total입력
		//System.out.println("kor : "+num.getKor());
		
		model.addAttribute("num",num);
		
		
		return "num/numResult";
	}
	
	
}
