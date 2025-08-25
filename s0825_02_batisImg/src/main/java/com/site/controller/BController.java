package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.site.dto.Board;
import com.site.service.BService;

@Controller
public class BController {
	
	@Autowired BService bService;
	
	//게시판 글쓰기 페이지열기
	@GetMapping("/board/bWrite")
	public String bWrite() {
		return "board/bWrite";
	}
	
	// 게시판 글쓰기 저장
	@PostMapping("/board/bWrite")
	public String bWrite(Board b,Model model) {
		bService.save(b);
		return "redirect:/board/bList?flag=1"; //flag=1-글쓰기 성공
	}
	
	
	//게시글 1개 가져오기
	@GetMapping("/board/bView/{bno}")
	public String bView(@PathVariable("bno") int bno,
			Model model) {
		Board board = bService.findBno(bno);
		model.addAttribute("board",board);
		System.out.println("bno : "+bno);
		return "board/bView";
	}
	
	//게시글 전체가져오기
	@GetMapping("/board/bList")
	public String bList(Model model) {
		//db에서 여러개의 board를 가져와야 함
		// BService연결
		List<Board> list = bService.findAll();
		model.addAttribute("list",list);		
		System.out.println("리스트 개수 : "+list.size());
		return "board/bList";
	}

}
