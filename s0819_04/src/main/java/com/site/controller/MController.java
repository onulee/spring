package com.site.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.dto.Member;
import com.site.service.MService;
import com.site.service.MServiceImpl;
import com.site.service.MServiceImpl2;

@Controller
public class MController {

	@Autowired MService mService;
	
	@GetMapping("/member/mList")
	public String mList(Model model) {
		
		List<Member> list = mService.selectAll();
		model.addAttribute("list",list);
		return "member/mList";
	}
	
	@GetMapping("/member/mView")
	public String mView(Model model) {
		// member 정보
//		MServiceImpl mServiceImpl = new MServiceImpl();
//		Member member = mServiceImpl.selectOne();
		// 유관순 정보를 가져와서 member전송하시오.
//		MService mService = new MServiceImpl2();
//		Member member = mService.selectOne();
		
		//스프링이 객체선언을 대행해서 주입(DI)
		Member member = mService.selectOne();
		model.addAttribute("member",member);
		return "member/mView";
	}
	
	@GetMapping("/member/member")
	public String member() {
		return "member/memberInput";
	}
	
	@PostMapping("/member/member")
	public String member(Member member,Model model) {

		mService.insertOne(member);
		return "redirect:/member/mList";
	}
}
