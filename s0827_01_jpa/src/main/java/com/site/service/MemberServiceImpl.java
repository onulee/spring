package com.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.site.dto.Member;
import com.site.repository.MemberRepository;

import jakarta.transaction.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberRepository memberRepository;
	
	@Override  //페이지로 리턴받음.
	public Page<Member> findAll(Pageable pageable) {
		Page<Member> list = memberRepository.findAll(pageable);
		return list;
	}
	
	@Override //회원전체리스트
	public List<Member> findAll() {
		
		// 예외처리가 필요없음.
		// 1. 정렬이 1개 일때
		List<Member> list = memberRepository.findAll(
				Sort.by("name").ascending()
		);
		
		// 2. 정렬이 2개 일때
//		List<Member> list = memberRepository.findAll(
//				Sort.by(Sort.Order.desc("gender"),
//						Sort.Order.asc("name")
//						)
//				); 
		
		// 3. 정렬을 분리해서 sort 보냄.
//		Sort sort = Sort.by(
//				Sort.Order.asc("gender"),
//				Sort.Order.desc("name")
//				);
//		List<Member> list = memberRepository.findAll(sort); //기본메소드 - Repository 메소드 필요없음.
		
		return list;
	}
	
	
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

	@Override //회원정보저장
	public void save(Member m) {
		memberRepository.save(m); //기본메소드 - Repository 메소드 필요없음.
	}

	@Override //회원정보 삭제
	@Transactional // 1개db관련 실행된후, 2번째에서 에러가 나면 rollback;
	public void delete(String id) {
		Member member = memberRepository.findById(id).get(); //검색
		memberRepository.delete(member); //삭제
		
	}


	

	

}
