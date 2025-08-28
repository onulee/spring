package com.site.service;

import java.util.List;

import com.site.dto.Member;

public interface MemberService {

	//findAll 메소드
	//회원전체리스트
	List<Member> findAll();	
	
	// findBy 메소드
	//id가 존재하는지 확인
	Member findById(String id);
	//로그인확인(id,pw)
	Member findByIdAndPw(String id, String pw);
	//임의로 이름변경
	Member findLogin(String id, String pw);

	// save 메소드
	//회원정보저장
	void save(Member m);

	
	

}
