package com.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.site.dto.Member;

@Mapper
public interface MemberMapper {

	//id,pw확인
	Member findByIdAndPw(@Param("id") String id,@Param("pw") String pw);

	//회원리스트
	List<Member> findAll();

	//회원상세보기
	Member findAndId(String id);

}
