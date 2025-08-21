package com.site.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.site.dto.Member;

@Mapper
public interface MemberMapper {

	//id,pw확인
	Member findByIdAndPw(@Param("id") String id,@Param("pw") String pw);

}
