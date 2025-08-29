package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.dto.Board;
import com.java.dto.Member;
import com.java.service.CustomerService;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {

	@Autowired CustomerService customerService;
	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	@GetMapping("/customer/write") //글쓰기 페이지열기
	public String write() {
		return "customer/write";
	}
	
	@PostMapping("/customer/write") //글쓰기 저장
	public String write( Board b,RedirectAttributes redirect ) {
	    String id = (String) session.getAttribute("session_id");
	    //글쓰기가 가능함. - member객체가 아니면 글쓰기가 안됨.
	    Member member = memberService.findById(id);
	    b.setMember(member); 
		//저장
	    customerService.save(b);
	    redirect.addFlashAttribute("flag","1");
		return "redirect:/customer/list";
	}
	
	@GetMapping("/customer/delete") //게시글 삭제
	public String delete(Board b,RedirectAttributes redirect,
			Model model) {
		System.out.println("controller delete bno : "+b.getBno());
		// 게시글삭제
		if(session.getAttribute("session_id") != null) {
			customerService.deleteById(b.getBno());
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
		// 정렬
		Sort sort = Sort.by(
			Sort.Order.desc("bgroup"),Sort.Order.asc("bstep")
		);
		
		//게시글 전체가져오기
		List<Board> list = customerService.findAll(sort);
		System.out.println("list 개수 : "+list.size());
		model.addAttribute("list",list);
		return "customer/list";
	}
}
