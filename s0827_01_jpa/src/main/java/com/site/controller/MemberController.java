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

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
   
	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	@GetMapping("/member/login") //로그인페이지 열기
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login") //로그인 확인
	public String login(HttpServletResponse response, Member m, Model model) {
		String url = "";
		System.out.println("id : "+m.getId());
		System.out.println("pw : "+m.getPw());
		//jpa 로 전달 : controller -> service -> serviceImpl -> dao(Jpa)
		// id,pw가 있는지 확인 - findByIdAndPw()
		Member member = memberService.findByIdAndPw(m.getId(),m.getPw());
		if(member.getId() == null) {
			System.out.println("아이디 또는 패스워드가 없습니다. 다시 입력하세요.");
			url = "/member/login";
		}else {
			System.out.println("로그인 성공.");
			url = "redirect:/?flag=1";
		}
		
		System.out.println("member : "+member);

		// id가 있는지 확인 - findById()
		//Member member = memberService.findById(m.getId()); 
		// 메소드이름을 임의로 변경
		//Member member = memberService.findLogin(m.getId(),m.getPw());
		
		return url;
	}
}
