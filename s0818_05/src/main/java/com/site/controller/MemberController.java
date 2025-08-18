package com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.site.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MemberController {
	
	@Autowired MemberService memberService; //자동으로 객체선언 됨.
	
	
//	@RequestMapping(method = RequestMethod.GET, value = "/member/login")
//	@RequestMapping(method = RequestMethod.POST, value = "/member/login")
//	@RequestMapping(value = "/member/login")
	@GetMapping("/member/login")
	public String login() {
		System.out.println("get방식으로 들어옴.");
		return "member/login";
	}
	
	
	@PostMapping("/member/login") // Model 형태
	public String login(HttpServletRequest request, 
			Model model) {
		System.out.println("post방식으로 들어옴.");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id : "+id);
		System.out.println("pw : "+pw);
		model.addAttribute("id",id); //view페이지 데이터 전송
		model.addAttribute("pw",pw);
		return "member/doLogin";
	}	
	
	
	
//	@PostMapping("/member/login") // ModelAndView 형태
//	public ModelAndView login(HttpServletRequest request) {
//		System.out.println("post방식으로 들어옴.");
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		System.out.println("id : "+id);
//		System.out.println("pw : "+pw);
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("member/doLogin"); //jsp페이지호출
//		mv.addObject("id",id);
//		mv.addObject("pw",pw);
//		return mv;
//	}
	


}
