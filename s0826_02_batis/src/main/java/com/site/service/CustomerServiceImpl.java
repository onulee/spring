package com.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dao.CustomerMapper;
import com.site.dto.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired CustomerMapper customerMapper;
	
	@Override //공지사항 모두 가져오기
	public List<Customer> findAll() {
		List<Customer> list = customerMapper.findAll();
		return list;
	}

}
