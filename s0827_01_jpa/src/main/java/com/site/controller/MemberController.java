package com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.site.dto.Member;
import com.site.service.MemberService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
   
	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	@GetMapping("/member/insert") //회원가입01 페이지열기
	public String insert() {
		return "member/insert01";
	}
	@GetMapping("/member/insert02") //회원가입02 페이지열기
	public String insert02() {
		return "member/insert02";
	}
	//ajax -> json데이터 전송
	@ResponseBody
	@PostMapping("/member/idBtn") // 중복id확인
	public String idBtn(Member m) {
		System.out.println("controller id : "+m.getId());
		// findById(m.getId) -> service,serviceImpl,repository
		Member member = memberService.findById(m.getId());
			
		
		
		String flag = "";
		if(member.getId() != null) {
			flag = "-1"; //아이디 사용불가
		}else {
			flag = "1";  // 아이디 사용가능
		}
		
		return flag;
	}
	
	@GetMapping("/member/logout") //로그아웃
	public String logout(RedirectAttributes redirect) {
		session.invalidate(); //섹션모두삭제
		redirect.addFlashAttribute("flag","-1");
		return "redirect:/";
	}
	
	@GetMapping("/member/login") //로그인페이지 열기
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login") //로그인 확인
	public String login(HttpServletResponse response, 
			RedirectAttributes redirect, Member m, Model model) {
		String url = "";
		System.out.println("id : "+m.getId());
		System.out.println("pw : "+m.getPw());
		//jpa 로 전달 : controller -> service -> serviceImpl -> dao(Jpa)
		// id,pw가 있는지 확인 - findByIdAndPw()
		Member member = memberService.findByIdAndPw(m.getId(),m.getPw());
		if(member.getId() == null) {
			System.out.println("아이디 또는 패스워드가 없습니다. 다시 입력하세요.");
			redirect.addFlashAttribute("flag","1"); // redirect시 변수전달가능
			url = "redirect:/member/login";
		}else {
			System.out.println("로그인 성공.");
			session.setAttribute("session_id", member.getId());
			session.setAttribute("session_name", member.getName());
			redirect.addFlashAttribute("flag","1"); // redirect시 변수전달가능
			url = "redirect:/";
		}
		
		System.out.println("member : "+member);

		// id가 있는지 확인 - findById()
		//Member member = memberService.findById(m.getId()); 
		// 메소드이름을 임의로 변경
		//Member member = memberService.findLogin(m.getId(),m.getPw());
		
		return url;
	}
}
