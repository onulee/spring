package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.Board;
import com.java.service.CustomerService;

@Controller
public class ReactController {

	@Autowired CustomerService customerService;
	
	@CrossOrigin
	@ResponseBody
	@GetMapping("/reactApi")
	public List<Board> reactApi(
			@RequestParam(name="page",defaultValue = "1") int page
			) {
		// Pageable 하단넘버링
		page = page-1; // pageable은 첫페이지가 0부터 시작
		int size = 10; //1페이지당 10개의 게시글을 가져옴.
		int rowperpage = 5; //하단넘버링 개수 5개
		// 정렬 - 답변달기
		Sort sort = Sort.by(
			Sort.Order.desc("bgroup"),Sort.Order.asc("bstep")
		);
		
		// 게시글 검색 : containing - 현재페이지,페이지당 개수, 정렬
		Pageable pageable = PageRequest.of(page, size, sort);	
		Page<Board> pageList = null;
		pageList = customerService.findAll(pageable);
        // 리턴타입 : Page - content, pageable
    		List<Board> list = pageList.getContent();
        return list;  
	}
}
