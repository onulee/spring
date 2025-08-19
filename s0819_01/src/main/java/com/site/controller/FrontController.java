package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //객체선언자동으로 진행
public class FrontController {
	
//	@RequestMapping() - get방식,post방식
//	@PostMapping() - post방식
	@GetMapping("/") // url주소 확인해서 해당되는 형태로 이동해서 실행
	public String index() {
		return "index";    // /WEB-INF/views/ index .jsp
	}

}
