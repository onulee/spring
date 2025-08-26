package com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.site.dto.Member;
import com.site.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	@GetMapping("/member/login") //login페이지 열기
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login") //login확인
	public String login(Member m,Model model) {
		System.out.println("id : "+m.getId());
		//controller -> service -> serviceImpl -> jpa
		Member member = memberService.findByIdAndPw(m);
		if(member.getId() != null) {
			System.out.println("로그인 되었습니다.");
		}else {
			System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
		}
		return "member/login";
	}

}
