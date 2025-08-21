package com.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dao.MemberMapper;
import com.site.dto.Member;

@Service
public class MServiceImpl implements MService {

	@Autowired MemberMapper memberMapper;
	
	@Override //id,pw확인
	public Member findByIdAndPw(String id, String pw) {
		Member member = memberMapper.findByIdAndPw(id,pw);
		return member;
	}

}
