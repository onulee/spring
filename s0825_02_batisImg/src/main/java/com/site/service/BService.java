package com.site.service;

import java.util.List;

import com.site.dto.Board;

public interface BService {

	//게시글 전체가져오기
	List<Board> findAll();
	//게시글 1개 가져오기
	Board findBno(int bno);
	//게시판 글쓰기 저장
	void save(Board b);

}
