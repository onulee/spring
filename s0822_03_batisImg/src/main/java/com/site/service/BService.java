package com.site.service;

import java.util.List;

import com.site.dto.Board;

public interface BService {

	//게시글 여러개가져오기
	List<Board> findAll();

	//게시글저장
	void save(Board b);

	//게시글 보기
	Board findByBno(int bno);

	//게시글 삭제
	void delete(int bno);

}
