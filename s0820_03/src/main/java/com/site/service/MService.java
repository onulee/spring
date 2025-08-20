package com.site.service;

import java.util.List;

import com.site.dto.Member;

public interface MService {

	//전체회원리스트
	List<Member> selectAll();

	//로그인 정보
	Member selectLogin(String id, String pw);

	//회원상세보기
	Member selectOne(String id);

}
