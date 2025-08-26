package com.site.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.dto.Customer;
import com.site.service.CustomerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {

	@Autowired CustomerService customerService;
	@Autowired HttpSession session;
	
	@GetMapping("/customer/list")
	public String list(
			@RequestParam(name="page",defaultValue = "1") int page,
			Model model) {
		Map<String, Object> map = customerService.findAll(page);
		model.addAttribute("map",map);
		return "customer/list";
	}
	
	
}
