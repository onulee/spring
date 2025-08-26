package com.site.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dao.CustomerMapper;
import com.site.dto.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired CustomerMapper customerMapper;
	
	@Override //공지사항 모두 가져오기 - page
	public Map<String, Object> findAll(int page) {
		int rowPerpage = 10; //1페이지 10개게시글 적용
		int countAll = customerMapper.findByCount(); //게시글 총개수
		int maxpage = (int)Math.ceil((double)countAll/rowPerpage);  //2.43 -> 3페이지
		int startpage = (int)((page-1)/10)*10+1;
		int endpage = (startpage-1)+10;
		if(maxpage<endpage) endpage = maxpage;
		System.out.println("CustomerServiceImpl startpage : "+startpage);
		System.out.println("CustomerServiceImpl endpage : "+endpage);
		//게시글개수 startrow,endrow
		int startrow = (page-1)*rowPerpage+1; //1,11,21
		int endrow = (startrow-1)+10; // 10,20,30
				
		// startrow,endrow
		List<Customer> list = customerMapper.findAll(startrow,endrow);
		Map<String, Object> map = new HashMap<>();
		map.put("countAll", countAll);
		map.put("maxpage", maxpage);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		map.put("page", page);
		map.put("list", list);
		
		return map;
	}

}
