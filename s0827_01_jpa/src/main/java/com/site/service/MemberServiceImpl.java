package com.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.Member;
import com.site.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberRepository memberRepository;
	
	@Override //id가 존재하는지 확인
	public Member findById(String id) {
		// findAll()-예외처리가 없음 리턴타입:List, findById()-예외처리
		// get() : 데이터를 검색하지 못했을 시, 에러발생
		// orElseGet() : 빈객체 리턴
		// orElseThrow() : 예외처리를 진행해서 예외코드 리턴
//		Member member = memberRepository.findById(id).get();
		Member member = memberRepository.findById(id).orElseGet(
				()->{ return new Member();  }
		);
//		Member member = memberRepository.findById(id).orElseThrow(
//				()->{ return new IllegalArgumentException();  }
//		);
		return member;
	}

	@Override //로그인 확인(id,pw)
	public Member findByIdAndPw(String id, String pw) {
		Member member = memberRepository.findByIdAndPw(id, pw).orElseGet(
				()->{ return new Member();  }
		);
		return member;
	}

	@Override //임의로 이름변경
	public Member findLogin(String id, String pw) {
		Member member = memberRepository.findLogin(id,pw).get();
		return member;
	}

}
