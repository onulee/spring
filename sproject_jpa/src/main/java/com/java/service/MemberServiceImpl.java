package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Member;
import com.java.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberRepository memberRepository;
	
	@Override //로그인 확인
	public Member findByIdAndPw(String id, String pw) {
		Member member = memberRepository.findByIdAndPw(id,pw);
		return member;
	}

}
