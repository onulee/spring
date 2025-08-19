package com.site.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.site.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Override
	public BoardDto selectOne() {
		// db에서 가져옴
		BoardDto boardDto = new BoardDto(1, "제목입니다.", "내용입니다.", 
				"aaa", 1, 0, 0, 0, new Date(), "");
		return boardDto;
	}

}
