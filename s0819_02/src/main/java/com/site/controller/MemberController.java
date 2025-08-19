package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/member")
public class MemberController {

	//회원가입
	@GetMapping("/member")
	public String member() {
		return "member/memberInput";
	}
	
	//회원가입
	@PostMapping("/member")
	public String member2(
			@RequestParam(name="id",defaultValue = "aaa") String id,
			Model model) {
		model.addAttribute("id",id);
		return "member/memberResult";
	}
	
	//로그인
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id : "+id);
		System.out.println("pw : "+pw);
		
		// jsp페이지로 데이터 전송방법
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		return "member/doLogin";
	}
	
	
}
