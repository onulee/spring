package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.dto.Board;
import com.site.service.BService;

@Controller
public class BController {

	@Autowired BService bService;
	
	@GetMapping("/bDelete")
	public String bDelete(
			@RequestParam(name="bno",defaultValue="0") int bno ) {
		System.out.println("bno : "+ bno);
		// 리턴없음, 매개변수 : bno
		// controller -> service -> serviceImpl -> dao -> xml
		
		bService.delete(bno);
		
		return "redirect:/bList?flag=2"; //flag:2 삭제
	}
	
	
	@GetMapping("/bView")
	public String bView(Board b,Model model) {
		//게시글 1개 - Board객체
		int bno = b.getBno();
		Board board = bService.findByBno(bno);
		model.addAttribute("board",board);
		return "bView";
	}
	
	@GetMapping("/bWrite") //게시글 글쓰기페이지
	public String bWrite() {
		return "bWrite";
	}
	
	@PostMapping("/bWrite") //게시글 글쓰기저장
	public String bWrite(Board b, Model model) {
		System.out.println("제목 : "+b.getBtitle());
		System.out.println("아이디 : "+b.getId());
		System.out.println("내용 : "+b.getBcontent());
		System.out.println("파일이미지 : "+b.getBfile());
		// controller -> service -> serviceImpl -> dao -> xml
		// 리턴없음. 매개변수 Board전송
		// 게시글저장
		bService.save(b);
		return "redirect:/bList?flag=1";
	}
	
	
	@GetMapping("/bList")
	public String bList(Model model) {
		// 게시글여러개 - List, 게시글1개 - Board객체
		// dto, controller -> service -> serviceImpl -> dao -> xml
		List<Board> list = bService.findAll();
		System.out.println("게시글 개수 : "+list.size());
		model.addAttribute("list",list);
		return "bList";
	}
}
