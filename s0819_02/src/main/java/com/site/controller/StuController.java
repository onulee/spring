package com.site.controller;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StuController {

	@GetMapping("/stu/stuInput")
	public String stuInput() {
		return "stu/stuInput";
	}
	
	@PostMapping("/stu/stuInput")
	public String stuInput(HttpServletRequest request,
			@RequestParam("sno") int sno,
			@RequestParam("name") String name,
			@RequestParam("kor") int kor,
			@RequestParam("eng") int eng,
			@RequestParam("math") int math,
			Model model) {
		
		//@RequestParam 사용
		
		// request 데이터 받음 - HttpServletRequest request
//		int sno = Integer.parseInt(request.getParameter("sno"));
//		String name = request.getParameter("name");
//		int kor = Integer.parseInt(request.getParameter("kor"));
//		int eng = Integer.parseInt(request.getParameter("eng"));
//		int math = Integer.parseInt(request.getParameter("math"));
		int total = kor+eng+math;
		double avg = total/3.0;
		// model 데이터 전달
		model.addAttribute("sno",sno);
		model.addAttribute("name",name);
		model.addAttribute("kor",kor);
		model.addAttribute("eng",eng);
		model.addAttribute("math",math);
		model.addAttribute("total",total);
		model.addAttribute("avg",avg);
		
		
		return "stu/stuResult";
	}
}
