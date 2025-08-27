package com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.site.dto.Member;
import com.site.service.MemberService;

@Controller
public class MemberController {
   
	@Autowired MemberService memberService;
	
	@GetMapping("/member/login") //로그인페이지 열기
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login") //로그인 확인
	public String login(Member m, Model model) {
		System.out.println("id : "+m.getId());
		System.out.println("pw : "+m.getPw());
		//jpa 로 전달 : controller -> service -> serviceImpl -> dao(Jpa)
		// id가 있는지 확인 - findById()
		Member member = memberService.findById(m.getId()); 
		System.out.println("member : "+member);
		// id,pw가 있는지 확인 - findByIdAndPw()
		
		return "member/login";
	}
}
