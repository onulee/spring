package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.Member;

// <객체리턴타입,리턴객체 primary key 변수타입>
public interface MemberRepository extends JpaRepository<Member, String> {
	// findAll(), findById(), save(), delete(), update() : 메소드정의 필요없음
	// 나머지 메소드 정의해야 함.
	// Pageable : 자동하단넘버링 페이지처리, Sort : 정렬
	// select * from member where id=#{id} and pw=#{pw}
	Member findByIdAndPw(String id, String pw);
	
	
}
