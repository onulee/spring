package com.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.Board;
import com.java.dto.Member;
import com.java.dto.Reply;
import com.java.service.CustomerService;
import com.java.service.MemberService;
import com.java.service.ReplyService;

import jakarta.servlet.http.HttpSession;

//@Controller
@RestController
public class ReplyController {

	// ajax사용하면 - RestApi
//	@GetMapping    // select
//	@PostMapping   // insert
//	@PutMapping    // update
//	@DeleteMapping // delete
	
	@Autowired MemberService memberService;
	@Autowired CustomerService customerService;
	@Autowired ReplyService replyService;
	@Autowired HttpSession session;
	
	@GetMapping("/reply/list")
	public String list() {
		return "성공 : list를 전달";
	}
	
	@PostMapping("/reply/write")
	public Reply write(Reply r, 
			@RequestParam("id") String id,
			@RequestParam("bno") int bno ) {
		// 데이터 확인
		System.out.println("rpw : "+r.getRpw());
		System.out.println("rcontent : "+r.getRcontent());
		System.out.println("id2 : "+id);
		System.out.println("bno : "+bno);
		// 데이터 추가
		Member member = memberService.findById(id);
		r.setMember(member);
		Board board = customerService.findByBno(bno);
		r.setBoard(board);
		// DB저장후 가져오기
		Reply reply = replyService.save(r);
		System.out.println("reply : "+reply.getRno());
		
		return reply; // reply 객체리턴 - 자동으로 Json파싱:무한루프발생
	}
	
	
}
