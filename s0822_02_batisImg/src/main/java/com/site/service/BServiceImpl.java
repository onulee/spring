package com.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dao.BoardMapper;
import com.site.dto.Board;

@Service
public class BServiceImpl implements BService {

	@Autowired BoardMapper boardMapper;
	
	@Override //게시글 전체가져오기
	public List<Board> findAll() {
		List<Board> list = boardMapper.findAll();
		return list;
	}

	@Override //게시글 1개
	public Board findByBno(int bno) {
		Board board = boardMapper.findByBno(bno);
		return board;
	}

	@Override //게시글저장
	public void save(Board board) {
		boardMapper.save(board);
	}

}
