package com.site.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dao.BoardMapper;
import com.site.dto.Board;

@Service
public class BServiceImpl implements BService {
	
	@Autowired BoardMapper boardMapper;

	@Override //게시글 모두 가져오기
	public Map<String, Object> findAll(int page) {
		// 1.게시글개수 2.maxpage
		int rowPerpage = 10; //1페이지당 게시글수
		int countAll = boardMapper.findByCount();
		int maxpage = (int)Math.ceil((double)countAll/rowPerpage);
		int startpage = ((int)(page-1)/10)*10+1;
		int endpage = (startpage-1)+10;
		if (maxpage<endpage) endpage = maxpage;
		
		// 페이지 리스트에 출력할 게시글개수 가져오기
		int startrow = (page-1)*rowPerpage+1;
		int endrow = (startrow-1)+10;
		System.out.println("시작 startrow : "+startrow);
		System.out.println("endrow : "+endrow);
		
		List<Board> list = boardMapper.findAll(startrow,endrow);
		Map<String, Object> map = new HashMap<>();
		map.put("countAll", countAll);
		map.put("maxpage", maxpage);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		map.put("page", page);
		map.put("list", list);
		
		System.out.println("countAll 개수 : "+countAll);
		return map;
	}
	
	
	
	// page Method를 생성해서 리턴받아도 됨.
//	public Map<String, Object> pageMethod(){
//		return "";
//	}

}
