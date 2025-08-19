package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController // 데이터로 전달 - ajax
@Controller // jsp page를 호출
public class MemberController {

	@GetMapping("/login")
	public String login() {
		return "member/login";
//		return "<h1>login-안녕하세요.</h1>";
	}
}
