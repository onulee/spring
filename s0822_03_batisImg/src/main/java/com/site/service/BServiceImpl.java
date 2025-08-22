package com.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dao.BoardMapper;
import com.site.dto.Board;

@Service
public class BServiceImpl implements BService {

	@Autowired BoardMapper boardMapper;
	
	@Override //게시글 여러개가져오기
	public List<Board> findAll() {
		List<Board> list = boardMapper.findAll();
		return list;
	}

	@Override // 게시글저장
	public void save(Board b) {
		boardMapper.save(b);
	}

}
