package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	
	@GetMapping("/customer/reply") //답변달기페이지 열기
	public String reply(Board b,Model model) {
		Board board = customerService.findByBno(b.getBno());
		System.out.println("controller bgroup : "+board.getBgroup());
		model.addAttribute("board",board);  //bgroup,bstep,bindent
		return "customer/reply";
	}
	
	@PostMapping("/customer/reply") //답변달기페이지 열기
	public String reply(Board b, @RequestPart("file") MultipartFile file,
			RedirectAttributes redirect) throws Exception {
		System.out.println("controller bgroup : "+b.getBgroup());
		
		if(!file.isEmpty()) {
			String originFileName = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			String uploadFileName = String.format("%d_%s", time,originFileName);
			String fileUrl = "c:/upload/";
	    	File f = new File(fileUrl+uploadFileName);
	    	//파일업로드 진행 - 예외처리
			file.transferTo(f);
			b.setBfile(uploadFileName); // 파일이름을 Board저장
		}
		
		// bno -> bno번호없음, bgroup, bstep,bindent -> 부모의 값을 그대로 가지고 있음.
		// bstep : 1증가해서 사용, bindent : 1증가해서 사용해야 함.
		// bgroup : 부모와 같은 그룹사용 
		// bstep : 부모보다 1증가해서 사용
		// bindent : 부모바다 1증가 해서 사용
		Member member = memberService.findById((String)session.getAttribute("session_id"));
		b.setMember(member);
		customerService.reply(b);
		redirect.addFlashAttribute("flag",3);
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/customer/update") //수정페이지 열기
	public String update(Board b, Model model) {
		Board board = customerService.findByBno(b.getBno());
		model.addAttribute("board",board);
		return "customer/update";
	}
	
	@PostMapping("/customer/update") //수정 저장
	public String update(Board b, @RequestPart("file") MultipartFile file,
			RedirectAttributes redirect, Model model) throws Exception {
		
		// Board board 불러옴. - 불러와서 진행
		Board board = customerService.findByBno(b.getBno());
		
		
		
		// bno,btitle,bcontent,file
		if(!file.isEmpty()) {
			String originFileName = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			String uploadFileName = String.format("%d_%s", time,originFileName);
			String fileUrl = "c:/upload/";
	    	File f = new File(fileUrl+uploadFileName);
	    	//파일업로드 진행
			file.transferTo(f);
			board.setBfile(uploadFileName); // 파일이름을 Board저장
			// 파일이름 중복방지방법
			//UUID uuid = UUID.randomUUID(); //487297927495728945729847592
			//String uploadFileName = String.format("%s_%s", uuid,originFileName);
		}
		// bfile,btitle,bcontent,bdate -> 새롭게 추가
		board.setBtitle(b.getBtitle());
		board.setBcontent(b.getBcontent());
		board.setBdate(new Timestamp(System.currentTimeMillis()));
		customerService.save(board);
		redirect.addFlashAttribute("flag",1);
		return "redirect:/customer/view?bno="+b.getBno();
	}
	
	@GetMapping("/customer/write") //글쓰기 페이지열기
	public String write() {
		return "customer/write";
	}
	
	@PostMapping("/customer/write") //글쓰기 저장
	public String write( Board b,
			@RequestPart("file") MultipartFile file,
			RedirectAttributes redirect ) {
	    String id = (String) session.getAttribute("session_id");
	    //글쓰기가 가능함. - member객체가 아니면 글쓰기가 안됨.
	    Member member = memberService.findById(id);
	    b.setMember(member); 
		//파일저장
	    if(!file.isEmpty()) {
	    	String originFileName = file.getOriginalFilename();
	    	// 이름중복방지를 위한 이름변경 - 밀리세컨드을 추가
	    	long time = System.currentTimeMillis();
	    	String uploadFileName = String.format("%d_%s", time,originFileName);
	    	System.out.println("uploadFileName : " + uploadFileName);
	    	
	    	// 39871398741937413_1.jpg
	    	// 파일저장 위치
	    	String fileUrl = "c:/upload/";
	    	File f = new File(fileUrl+uploadFileName);
	    	//파일업로드 진행
	    	try {
				file.transferTo(f);
				b.setBfile(uploadFileName); // 파일이름을 Board저장
			} catch (Exception e) {e.printStackTrace();}
	    }
	    // 게시글 저장 
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
	
	@Transactional
	@GetMapping("/customer/view") //상세페이지 열기
	public String view(Board b, Model model) {
		System.out.println("controller bno : "+b.getBno());
		Board board = customerService.findByBno(b.getBno());
		model.addAttribute("board",board);
		return "customer/view";
	}
	
	@GetMapping("/customer/list") //게시판리스트
	public String list(
			@RequestParam(name="page",defaultValue = "1") int page,
			Model model) {
		// Pageable 하단넘버링
		page = page-1; // pageable은 첫페이지가 0부터 시작
		int size = 7; //1페이지당 10개의 게시글을 가져옴.
		int rowperpage = 5; //하단넘버링 개수 5개
		// 정렬 - 답변달기
		Sort sort = Sort.by(
			Sort.Order.desc("bgroup"),Sort.Order.asc("bstep")
		);
		
		// 게시글 가져오기 - 현재페이지,페이지당 개수
//		Pageable pageable = PageRequest.of(page, size);
		// 게시글 가져오기 - 현재페이지,페이지당 개수, 정렬
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<Board> pageList = customerService.findAll(pageable);
		
		// 리턴타입 : Page - content, pageable
		List<Board> list = pageList.getContent();
		int count = pageList.getNumberOfElements(); // 총게시글수
		page = pageList.getPageable().getPageNumber()+1; // 현재페이지는 시작이 0 이므로 +1를 해줌.
		int maxpage = pageList.getTotalPages();     // 마지막페이지
		int startpage = ((page-1)/rowperpage)*rowperpage + 1;       // 하단넘버링 시작번호
		int endpage = (startpage-1)+rowperpage;             // 하단넘버링 끝번호
		if (endpage>maxpage) endpage = maxpage;     // 끝번호가 마지막페이지번호보다 크면 마지막번호를 넣음.
		
		model.addAttribute("list",list);
		model.addAttribute("page",page);
		model.addAttribute("maxpage",maxpage);
		model.addAttribute("startpage",startpage);
		model.addAttribute("endpage",endpage);
		
		
		// 게시글 가져오기 - 정렬만
		//List<Board> list = customerService.findAll(sort);
		//System.out.println("list 개수 : "+list.size());
		//model.addAttribute("list",list);
		//return "customer/list";
		
		return "customer/list";
	}
}
