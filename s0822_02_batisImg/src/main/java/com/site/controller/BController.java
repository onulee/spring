package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.site.dto.Board;
import com.site.service.BService;

@Controller
public class BController {

	@Autowired BService bService;
	
	@GetMapping("/board/bWrite") //글쓰기페이지
	public String bWrite() {
		return "bWrite";
	}
	
	@PostMapping("/board/bWrite") //글쓰기저장
	public String bWrite(Board board, Model model) {
		System.out.println("제목 : "+board.getBtitle());
		System.out.println("내용 : "+board.getBcontent());
		System.out.println("작성자 : "+board.getId());
		System.out.println("첨부파일 : "+board.getBfile());
		return "bWrite";
	}
	
	@GetMapping("/board/bList")
	public String bList(Model model) {
		// controller -> service -> serviceImpl -> dao -> xml
		List<Board> list = bService.findAll();
		model.addAttribute("list",list);
		return "bList";
	}
	
	@GetMapping("/board/bView")
	public String bView(Board b, Model model) {
		// controller -> service -> serviceImpl -> dao -> xml
		// 게시글1개 - bno
		int bno = b.getBno();
		Board board = bService.findByBno(bno);
		model.addAttribute("board",board);
		return "bView";
	}
}
