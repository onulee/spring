package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.dto.Member;
import com.site.service.MService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MController {

	@Autowired MService mService;
	@Autowired HttpSession session;
	
	@GetMapping("/member/mView") //회원상세보기
	public String mView(
			@RequestParam(name="id",defaultValue = "aaa") String id,
			Model model) {
		// service연결 List-여러개,객체-1개
		Member member = mService.findAndId(id);
		model.addAttribute("member",member);
		return "member/mView";
	}
	
	@GetMapping("/member/mList") //회원리스트
	public String mList(Model model) {
		// service연결 List-여러개,객체-1개
		List<Member> list = mService.findAll();
		model.addAttribute("list",list);
		return "member/mList";
	}
	
	
	@GetMapping("/member/login") //로그인페이지
	public String login(
			@RequestParam(name="flag",required = false) String flag,
			Model model) {
		model.addAttribute("flag",flag);
		System.out.println("flag : "+flag);
		return "member/login";
	}
	
	@GetMapping("/member/logout") //로그아웃
	public String logout(Model model) {
		//session삭제
		session.invalidate(); //섹션모두삭제
		return "redirect:/?flag=2";
	}
	
	@PostMapping("/member/login") //로그인확인
	public String login(Member member,Model model) {
		//id,pw 아이디,패스워드 일치하는지 확인
		String id = member.getId();
		String pw = member.getPw();
		Member mem = mService.findByIdAndPw(id,pw);
		
		//Member객체 확인
		if(mem==null) {
			System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
			return "redirect:/member/login?flag=-1";
		}else {
			System.out.println("로그인 성공");
			session.setAttribute("session_id", mem.getId());
			session.setAttribute("session_name", mem.getName());
			return "redirect:/?flag=1";
		}
		
	}
	
	
	
	
}
