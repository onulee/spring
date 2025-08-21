package com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.dto.Member;
import com.site.service.MService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MController {

	@Autowired MService mService;
	
	@GetMapping("/member/login") //로그인페이지
	public String login(
			@RequestParam(name="flag",required = false) String flag,
			Model model) {
		model.addAttribute("flag",flag);
		System.out.println("flag : "+flag);
		return "member/login";
	}
	
	@PostMapping("/member/login") //로그인페이지
	public String login(Member member,Model model) {
		//id,pw 아이디,패스워드 일치하는지 확인
		String id = member.getId();
		String pw = member.getPw();
		Member mem = mService.findByIdAndPw(id,pw);
		
		//Member객체 확인
		if(mem==null) {
			System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
			return "redirect:/member/login?flag=-1";
		}else {
			System.out.println("로그인 성공");
			return "redirect:/?flag=1";
		}
		
	}
	
	
	
	
}
