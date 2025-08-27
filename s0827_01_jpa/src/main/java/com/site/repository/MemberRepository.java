package com.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.dto.Member;

// <Member,String> : 리턴객체,객체기본키타입
// select-findAll() findById()
// ,insert-save(),update-update(),delete-delete() 기본메소드 정의
//@Repository //생략가능
public interface MemberRepository extends JpaRepository<Member, String> {

	
	
	
}
