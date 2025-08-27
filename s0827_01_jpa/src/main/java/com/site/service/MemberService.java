package com.site.service;

import com.site.dto.Member;

public interface MemberService {

	//id가 존재하는지 확인
	Member findById(String id);

	//로그인확인(id,pw)
	Member findByIdAndPw(String id, String pw);

	//임의로 이름변경
	Member findLogin(String id, String pw);

}
