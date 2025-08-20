package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.site.dto.Member;
import com.site.service.MService;

@Controller
public class MController {

	@Autowired MService mService;
	
	@GetMapping("/member/mList")
	public String mList(Model model) {
		//회원전체리스트 - List, 회원1개 - 객체(Member), 회원수 - int
		List<Member> list = mService.selectAll();
	    System.out.println("회원정보 개수 : "+list.size());
	    //데이터전달
		model.addAttribute("list",list);
		return "member/mList";
	}
}
