package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.Board;
import com.java.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired CustomerService customerService;
	
	@GetMapping("/customer/view") //상세페이지 열기
	public String view(Board b, Model model) {
		System.out.println("controller bno : "+b.getBno());
		Board board = customerService.findByBno(b.getBno());
		model.addAttribute("board",board);
		return "customer/view";
	}
	
	
	@GetMapping("/customer/list")
	public String list(Model model) {
		//List<Board> controller -> service -> serviceImpl -> Jpa
		//게시글 전체가져오기
		List<Board> list = customerService.findAll();
		System.out.println("list 개수 : "+list.size());
		model.addAttribute("list",list);
		return "customer/list";
	}
}
