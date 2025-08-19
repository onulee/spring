package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.site.dto.Num;
import com.site.dto.Stu;

@Controller
public class StuController {

	@GetMapping("/stu/stu")
	public String stuInput() {
		return "stu/stuInput";
	}
	
	@PostMapping("/stu/stu")
	public String numInput(Stu stu, Model model) {
		stu.setTotal(stu.getKor()+stu.getEng()+stu.getMath());
		stu.setAvg(stu.getTotal()/3.0);
		model.addAttribute("stu",stu);
		
		
		return "stu/stuResult";
	}
	
	
}
