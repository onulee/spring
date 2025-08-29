package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.dto.Board;
import com.java.service.CustomerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {

	@Autowired CustomerService customerService;
	@Autowired HttpSession session;
	
	@GetMapping("/customer/delete") //게시글 삭제
	public String delete(Board b,RedirectAttributes redirect,
			Model model) {
		System.out.println("controller delete bno : "+b.getBno());
		// 섹션이 null이 아닐때 삭제가능
		if(session.getAttribute("session_id") != null) {
			// session_id 삭제하려는 게시글 id와 같은지 비교
			
			redirect.addFlashAttribute("flag","-1");
			return "redirect:/customer/list";
		}else {
			System.out.println("제대로 된 삭제URL이 아님.");
			return "customer/view";
		}
		
	}
	
	@GetMapping("/customer/view") //상세페이지 열기
	public String view(Board b, Model model) {
		System.out.println("controller bno : "+b.getBno());
		Board board = customerService.findByBno(b.getBno());
		model.addAttribute("board",board);
		return "customer/view";
	}
	
	@GetMapping("/customer/list") //게시판리스트
	public String list(Model model) {
		//List<Board> controller -> service -> serviceImpl -> Jpa
		//게시글 전체가져오기
		List<Board> list = customerService.findAll();
		System.out.println("list 개수 : "+list.size());
		model.addAttribute("list",list);
		return "customer/list";
	}
}
