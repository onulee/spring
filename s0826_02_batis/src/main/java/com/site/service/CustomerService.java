package com.site.service;

import java.util.List;
import java.util.Map;

import com.site.dto.Customer;

public interface CustomerService {

	//공지사항 모두 가져오기 - page
	Map<String, Object> findAll(int page);

}
