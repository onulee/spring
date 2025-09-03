package com.java.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.java.dto.Board;
import com.java.dto.Member;

public interface CustomerService {

	//게시글 전체가져오기 - 현재페이지, 페이지당 개수
	Page<Board> findAll(Pageable pageable);
	
	//게시글 전체가져오기 - 정렬 : bgroup역순정렬, bstep순차정렬
	List<Board> findAll(Sort sort);

	//게시글 1개 가져오기 - board,preBoard,nextBoard
	Map<String, Object> findByBno(int bno);

	//게시글 삭제
	void deleteById(int bno);

	//글쓰기 저장
	void save(Board b);

	//답변달기 저장
	void reply(Board b);


}
