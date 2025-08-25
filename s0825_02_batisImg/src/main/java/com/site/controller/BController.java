package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.dto.Board;
import com.site.service.BService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BController {
	
	@Autowired BService bService;
	@Autowired HttpSession session;
	
	//게시글 수정 저장
	@PostMapping("/board/bUpdate")
	public String bUpdate(Board b, @RequestParam("bfile2") String bfile2) {
		// 첨부된 파일이 없으면 기존 첨부된 파일을 업데이트 함.
		if(b.getBfile() == null) {
			b.setBfile(bfile2);
		}
		
		bService.update(b);
		return "redirect:/board/bList?flag=2"; //flag=2 : 수정
	}
	//게시글 수정 페이지 열기
	@GetMapping("/board/bUpdate/{bno}")
	public String bUpdate(@PathVariable("bno") int bno,
			Model model) {
		// 게시글 1개 가져오기
		Board board = bService.findBno(bno);
		model.addAttribute("board",board);
		System.out.println("bno : "+bno);
		return "board/bUpdate";
	}
	
	
	// 게시글 삭제
	@GetMapping("/board/bDelete/{bno}")
	public String bDelete(@PathVariable("bno") int bno,
			Model model) {
//		if(session.getAttribute("session_id") !=null) {
//			//삭제가능하게 함.
//		}
		//게시글 삭제
		bService.delete(bno);
		return "redirect:/board/bList?flag=-1"; // flag=-1 : 삭제팝업창
	}
	
	//게시판 글쓰기 페이지열기
	@GetMapping("/board/bWrite")
	public String bWrite() {
		return "board/bWrite";
	}
	
	// 게시판 글쓰기 저장
	@PostMapping("/board/bWrite")
	public String bWrite(Board b) {
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
	public String bList(
			@RequestParam(name="flag",required = false) String flag,
			Model model) {
		//db에서 여러개의 board를 가져와야 함
		// BService연결
		List<Board> list = bService.findAll();
		model.addAttribute("list",list);		
		model.addAttribute("flag",flag); // 없을때 null, 1: 저장		
		System.out.println("리스트 개수 : "+list.size());
		return "board/bList";
	}

}
