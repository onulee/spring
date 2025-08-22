package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.dto.Board;
import com.site.service.BService;

@Controller
public class BController {

	@Autowired BService bService;
	
	@GetMapping({"/board/bView","/board/bView/{bno}"})
	public String bView(
//			@PathVariable(value = "bno",required = false) int bno,
//			@RequestParam(name="bno",defaultValue = "1") int bno,
			Board board, Model model) {
		int bno = board.getBno();
		System.out.println("게시글 번호 : "+bno);
		//게시글1개 - board객체
		Board b = bService.findByBno(bno);
		model.addAttribute("board",b);
		return "board/bView";
	}
	
	
	@GetMapping("/board/bList") //게시글 전체보기
	public String bList(Model model) {
		// 게시글 여러개 - List, 1개 - board객체
		List<Board> list = bService.findAll();
		model.addAttribute("list",list);
		return "board/bList";
	}
}
