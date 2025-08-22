package com.site.service;

import java.util.List;

import com.site.dto.Member;

public interface MService {

	//로그인확인
	Member findByIdAndPw(String id, String pw);
    //회원리스트
	List<Member> findAll();
	//회원상세보기
	Member findAndId(String id);

}
