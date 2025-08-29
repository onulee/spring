package com.java.service;

import java.util.List;

import com.java.dto.Board;

public interface CustomerService {

	//게시글 전체가져오기
	List<Board> findAll();

	//게시글 1개 가져오기
	Board findByBno(int bno);

	//게시글 삭제
	void delete(int bno);

}
