package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice // Controller중 제일 먼저 실행이 됨.
@RestController   // 데이터로 리턴
public class GlobalExceptionHandler {
	
	// IllegalArgumentException발생된 에러페이지에 getMessage() 전달함.
	public String handleArgumentException(
			Exception e,Model model) {
		//model.addAttribute("message",e.getMessage());
		return e.getMessage();
	}

}
