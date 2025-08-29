package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice // Controller중 제일 먼저 실행이 됨.
//@RestController   // 데이터로 리턴
@Controller         // 페이지 리턴
public class ExceptionController {
	
	// 각각의 예외처리를 진행할수 있음
	
	// 최상위 예외 - Exception
	@ExceptionHandler(Exception.class)
	public String handleArgumentException(
			Exception e,Model model) {
		model.addAttribute("message",e.getMessage());
		return "error";
	}
	
	// IllegalArgumentException발생된 에러페이지에 getMessage() 전달함.
	@ExceptionHandler(IllegalArgumentException.class)
	public String handleArgumentException(
			IllegalArgumentException e,Model model) {
		model.addAttribute("message",e.getMessage());
		return "error";
	}
	
	
	@ExceptionHandler(ArithmeticException.class)
	public String handleArgumentException(
			ArithmeticException e,Model model) {
		model.addAttribute("message",e.getMessage());
		return "error";
	}

}
