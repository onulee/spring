package com.site.service;

import java.util.List;

import com.site.dto.Member;

public interface MService {

	//회원정보 1개
	Member selectOne();
	
	//회원정보 여러개
	List<Member> selectAll();

	//회원정보 저장
	void insertOne(Member member);
	

}
