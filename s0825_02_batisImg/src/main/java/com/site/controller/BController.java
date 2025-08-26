package com.site.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

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
		if(b.getBfile() == "") {
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
	
	// 파일여러개 List<MultipartFile> files
	// 게시판 글쓰기 저장
	@PostMapping("/board/bWrite")
	public String bWrite(Board b,
			@RequestPart("file") MultipartFile file) {
		b.setBfile(""); //null경우 에러가 나서, 빈공백을 추가
		//파일첨부가 되어 있어야 진행
		if(!file.isEmpty()) {
			// 원본파일이름 가져오기
			String originFileName = file.getOriginalFilename();
			// 동일이름이 생기지 않도록 시간을 이름에 추가
			long time = System.currentTimeMillis();
			// 1.jpg -> 48459848493939_1.jpg
			String uploadName = String.format("%d_%s", time,originFileName);
			// 파일저장위치
			String fileLocation = "c:/upload/";
			File f = new File(fileLocation+uploadName); //c:upload/48459848493939_1.jpg 
			b.setBfile(uploadName); //board객체의 bfile 이름추가
			try { file.transferTo(f); //파일업로드 진행
			} catch (Exception e) { e.printStackTrace(); } 
		}
		// 파일첨부가 없으면 글만 저장
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
	
	//게시글 검색
	@GetMapping("/board/search")
	public String search(
			@RequestParam("category") String category,
			@RequestParam("sWord") String sWord,
			Model model) {
		System.out.println("카테고리 : "+category);
		System.out.println("검색 : "+sWord);
		//검색 게시글 여러개 가져오기
		List<Board> list = bService.findByCaAndSWord(category,sWord);
		model.addAttribute("list",list);
		
		return "board/bList";
	}
	
	//게시글 전체가져오기
	@GetMapping("/board/bList")
	public String bList(
			@RequestParam(name="page",defaultValue = "1") int page,
			@RequestParam(name="flag",required = false) String flag,
			Model model) {
		// Map으로 리턴 받음 - 여러개의 object로 리턴받음
		//db에서 여러개의 board를 가져와야 함
		// BService연결 
		List<Board> list = bService.findAll(page);
		model.addAttribute("list",list);		
		model.addAttribute("flag",flag); // 없을때 null, 1: 저장		
		return "board/bList";
	}

}
