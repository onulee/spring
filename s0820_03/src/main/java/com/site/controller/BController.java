package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.dto.Board;
import com.site.dto.Member;
import com.site.service.BService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
public class BController {

	@Autowired BService bService;
	
	@GetMapping("/board/bList")
	public String board(Model model) {
		//db에서 데이터 가져오기
		List<Board> list = bService.selectAll();
		model.addAttribute("list",list);
		return "board/blist";
	}
}
