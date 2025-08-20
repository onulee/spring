package com.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.site.dto.Member;

@Mapper
public interface MemberMapper {

	//전체회원리스트
	List<Member> selectAll();

	//로그인정보
	Member selectLogin(@Param("id") String id, @Param("pw") String pw);

	//회원상세보기
	Member selectOne(String id);

}
