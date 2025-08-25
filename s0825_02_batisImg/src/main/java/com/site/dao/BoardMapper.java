package com.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.site.dto.Board;

@Mapper
public interface BoardMapper {

	//게시글 전체가져오기
	List<Board> findAll();
    //게시글 1개 가져오기
	Board findBno(int bno);
	//게시판 글쓰기 저장
	void save(Board b);
	//게시글 삭제
	void delete(int bno);
	//게시글 수정 저장
	void update(Board b);
	//검색 게시글 여러개 가져오기
	List<Board> findByCaAndSWord(@Param("category") String category,
			@Param("sWord") String sWord);

}
