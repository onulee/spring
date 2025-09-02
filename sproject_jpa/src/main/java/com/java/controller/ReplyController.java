package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.Reply;

//@Controller
@RestController
public class ReplyController {

	// ajax사용하면 - RestApi
//	@GetMapping    // select
//	@PostMapping   // insert
//	@PutMapping    // update
//	@DeleteMapping // delete
	
	@GetMapping("/reply/list")
	public String list() {
		return "성공 : list를 전달";
	}
	
	@PostMapping("/reply/write")
	public String write(Reply r) {
		return "성공 : 입력후 Reply객체를 전달"; 
	}
	
	
}
