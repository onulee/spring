package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.site.dto.Customer;
import com.site.service.CustomerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {

	@Autowired CustomerService customerService;
	@Autowired HttpSession session;
	
	@GetMapping("/customer/list")
	public String list(Model model) {
		List<Customer> list = customerService.findAll();
		model.addAttribute("list",list);
		return "customer/list";
	}
	
	
}
