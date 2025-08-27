package com.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.Member;
import com.site.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberRepository memberRepository;
	
	@Override
	public Member findById(String id) {
		// get() : 데이터를 검색하지 못했을 시, 에러발생
		// orElseGet() : 빈객체 리턴
		// orElseThrow() : 예외처리를 진행해서 예외코드 리턴
		Member member = memberRepository.findById(id).get();
//		Member member = memberRepository.findById(id).orElseGet(
//				()->{ return new Member();  }
//		);
//		Member member = memberRepository.findById(id).orElseThrow(
//				()->{ return new IllegalArgumentException();  }
//		);
		return member;
	}

}
