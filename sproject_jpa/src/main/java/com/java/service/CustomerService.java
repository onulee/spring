package com.java.service;

import java.util.List;

import com.java.dto.Board;
import com.java.dto.Member;

public interface CustomerService {

	//게시글 전체가져오기
	List<Board> findAll();

	//게시글 1개 가져오기
	Board findByBno(int bno);

	//게시글 삭제
	void deleteById(int bno);

	//글쓰기 저장
	void save(Board b);

}
