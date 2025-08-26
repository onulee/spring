package com.site.service;

import com.site.dto.Member;

public interface MemberService {

	//로그인 확인
	Member findByIdAndPw(Member m);

}
