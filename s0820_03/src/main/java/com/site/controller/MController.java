package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.site.dto.Member;
import com.site.service.MService;

@Controller
public class MController {
	
	@Autowired MService mService;
	
	// 회원상세보기
	@GetMapping("/member/mView")
	public String mView(Model model) {
		String id = "aaa";
		Member member = mService.selectOne(id);
		model.addAttribute("member",member);
		return "member/mView";
	}
	
	//로그인화면
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	//로그인확인
	@PostMapping("/member/login")
	public String login(Member member, Model model) {
		System.out.println("아이디 : "+member.getId());
		System.out.println("패스워드 : "+member.getPw());
		String id = member.getId();
		String pw = member.getPw();
		//select 검색 - 1개 또는 0개
		Member m = mService.selectLogin(id,pw);
		if(m==null) {
			System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
		}else {
			System.out.println("아이디 : "+m.getId()+" - 로그인성공!");
		}
		return "member/login";
	}
	
	
	
	@GetMapping("/member/mList")
	public String mList(Model model) {
		//db에서 데이터 가져오기
		List<Member> list = mService.selectAll();
		//1개
		//Member member = mService.selectOne();
		// jsp로 데이터 전달
		model.addAttribute("list",list);
		return "member/mList";
	}

}
