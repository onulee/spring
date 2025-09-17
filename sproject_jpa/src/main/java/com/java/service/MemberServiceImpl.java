package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Member;
import com.java.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
	
	@Override //회원가입 저장
	public Member save(Member m) {
		Member member = memberRepository.save(m);
		return member;
	}
	
	
	@Override //로그인 확인
	public Member findByIdAndPw(String id, String pw) {
		Member member = memberRepository.findByIdAndPw(id,pw);
		return member;
	}

	@Override //회원1명 검색
	public Member findById(String id) {
		Member member = memberRepository.findById(id).orElseGet(
			() -> {return new Member();}	
		);
		return member;
	}

	

}
