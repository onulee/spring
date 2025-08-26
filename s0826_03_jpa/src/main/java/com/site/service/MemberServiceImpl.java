package com.site.service;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.Member;
import com.site.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberRepository memberRepository;
	
	@Override
	public Member findByIdAndPw(Member m) {
		String id = m.getId();
		String pw = m.getPw();
		// orElseGet() : find메소드를 진행할때 데이터가 없을 경우 빈객체 생성
		// Jpa 규칙 find By Id:id데이터값을 주입
		// findByIdAndPw select * from member where id=#{id} and pw=#{pw}
        // findById - 기본메소드로 제공
		Member member = memberRepository.findByIdAndPw(id,pw).orElseGet(
				() -> {return new Member();}
		);
		
		// orElseThrow() : find메소드를 진행할때 데이터가 없을경우 에러발생
//		Member member = memberRepository.findByIdAndPw(id,pw).orElseThrow(
//			//예외처리 - 람다식
//			() -> {
//				return new IllegalArgumentException("예외발생-데이터가 없음");
//			}
//		);
		return member;
	}

}
