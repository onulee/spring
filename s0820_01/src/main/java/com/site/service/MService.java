package com.site.service;

import java.util.List;

import com.site.dto.Member;

public interface MService {

	//회원전체리스트
	List<Member> selectAll();

}
