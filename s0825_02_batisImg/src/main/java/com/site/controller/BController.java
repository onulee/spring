package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.site.dto.Board;
import com.site.service.BService;

@Controller
public class BController {
	
	@Autowired BService bService;
	
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
