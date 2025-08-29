package com.java.service;

import com.java.dto.Member;

public interface MemberService {

	//로그인 확인
	Member findByIdAndPw(String id, String pw);

	// 회원1명 검색
	Member findById(String id);

}
