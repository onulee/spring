package com.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.dto.Board;

@Mapper
public interface BoardMapper {

	//게시글 모두 가져오기
	List<Board> findAll();
    //게시글 총개수
	int findByCount();

}
