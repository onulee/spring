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
	public List<Board> findAll(String page) {
//		1. 총 게시글 수 ( listCountAll ) - 17
//		2. 현재 페이지 ( page ) - 1
//		3. 최대 페이지 ( maxpage ) 
//		4. 첫 페이지 ( startpage )
//		5. 마지막 페이지 ( endpage )
        int rowPerpage = 10; //1page에 10개의 게시글을 출력
//        int maxPage = Math.ceil();
		
		int listCountAll = boardMapper.findByCount();
		System.out.println("BServiceImpl 게시글 전체개수 : "+listCountAll);
		List<Board> list = boardMapper.findAll();
		return list;
	}

	@Override //게시글 1개 가져오기
	public Board findBno(int bno) {
		Board board = boardMapper.findBno(bno);
		return board;
	}

	@Override //게시판 글쓰기 저장
	public void save(Board b) {
		boardMapper.save(b);
		
	}

	@Override //게시글 삭제
	public void delete(int bno) {
		boardMapper.delete(bno);
	}

	@Override //게시글 수정 저장
	public void update(Board b) {
		boardMapper.update(b);
	}

	@Override //검색 게시글 여러개 가져오기
	public List<Board> findByCaAndSWord(String category, String sWord) {
		List<Board> list = boardMapper.findByCaAndSWord(category,sWord);
		return list;
	}

}
