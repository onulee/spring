package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired CustomerRepository customerRepository;
	
	@Override //게시글 전체가져오기
	public List<Board> findAll() {
		List<Board> list = customerRepository.findAll();
		return list;
	}

}
