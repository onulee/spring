package com.site.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.site.dto.Member;

// <Member,String> : 리턴객체,객체기본키타입
// select-findAll() findById()
// ,insert-save(),update-update(),delete-delete() 기본메소드 정의
//@Repository //생략가능
public interface MemberRepository extends JpaRepository<Member, String> {

	//로그인확인(id,pw) - select할때 데이터가 찾아지면 Optional 객체리턴
	// select할때 데이터가 없으면 Optional
	// select * from member where id = #{id} and pw=#{pw}
	Optional<Member> findByIdAndPw(String id, String pw);

	@Query(value = "select * from member where id=? and pw=?",nativeQuery = true)
	Optional<Member> findLogin(String id, String pw);

	
	
	
}
