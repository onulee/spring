package com.site.service;

import org.springframework.stereotype.Service;

import com.site.dto.Member;

@Service
public class MServiceImpl implements MService {

	//member 정보가 있음
	Member member = new Member("aaa", "1111", "홍길동", "010-1111-1111", "남자", "게임,골프");
    
	
	
}
