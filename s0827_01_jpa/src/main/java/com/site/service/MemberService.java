package com.site.service;

import com.site.dto.Member;

public interface MemberService {

	//id가 존재하는지 확인
	Member findById(String id);

}
