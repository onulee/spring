package com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.site.dto.BoardDto;
import com.site.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired BoardService boardService;
	
	@GetMapping("/list")
	public String board(Model model) {
		//db에서 가져와야 하는 내용 - 게시글 전체가져오기 (ArrayList<BoardDto>)
		
		
		return "board/list";
	}
	
	@GetMapping("/view")
	public String view(Model model) {
		//db에서 가져와야 하는 내용 - 게시글 1개 (BoardDto)
		BoardDto boardDto = boardService.selectOne();
		//jsp 데이터 전송
		model.addAttribute("boardDto",boardDto);
		
		return "board/view";
	}

}
