package com.site.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.dto.Member;

@Controller
public class MController {

	@GetMapping("/member/mView")
	public String mView() {
		// member 정보
		
		
		
		return "member/mView";
	}
	
	@GetMapping("/member/member")
	public String member() {
		return "member/memberInput";
	}
	
	@PostMapping("/member/member")
	public String member(Member member,Model model) {
//		System.out.println(Arrays.toString(hobby));
		model.addAttribute("member",member);
		return "member/memberResult";
	}
}
