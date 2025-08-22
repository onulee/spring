package com.site.service;

import java.util.List;

import com.site.dto.Board;

public interface BService {

	//게시글 전체가져오기
	List<Board> findAll();

	//게시글 1개
	Board findByBno(int bno);

}
