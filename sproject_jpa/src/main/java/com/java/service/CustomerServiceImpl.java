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

	@Override
	public Board findByBno(int bno) {
		// .get():에러처리안함 .orElseGet():빈객체처리 .roElseThrow():예외처리
		Board board = customerRepository.findById(bno).orElseThrow(
		 () -> { 
			return new IllegalArgumentException("해당되는 게시글이 존재하지 않습니다."); 
		 }
		);
		
		return board;
	}

}
