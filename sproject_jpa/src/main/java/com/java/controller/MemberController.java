package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.dto.Member;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	@GetMapping("/member/login") //로그인페이지 열기
	public String login() {
		return "/member/login";
	}
	@PostMapping("/member/login") // 로그인 확인
	public String login(
			RedirectAttributes redirect, //redirect 변수전달
			HttpServletRequest request,  //쿠키사용
			Member m  //id,pw
			) {
		String redirectUrl = "";
		System.out.println("controller id : "+m.getId());
		System.out.println("controller pw : "+m.getPw());
		// controller -> service -> serviceImpl -> Jpa
		Member member = memberService.findByIdAndPw(m.getId(),m.getPw());
		if(member.getId()==null) {
			System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
			redirect.addFlashAttribute("flag","-1");
			return "redirect:/member/login/";
		}else {
			redirect.addFlashAttribute("flag","1");
			return "redirect:/";
		}
		
	}
}
