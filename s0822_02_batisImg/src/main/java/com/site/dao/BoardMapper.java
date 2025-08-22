package com.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.dto.Board;

@Mapper
public interface BoardMapper {

	//게시글 전체가져오기
	List<Board> findAll();

	//게시글 1개
	Board findByBno(int bno);

}
