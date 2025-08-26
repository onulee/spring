package com.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.site.dto.Customer;

@Mapper
public interface CustomerMapper {

	//공지사항 모두 가져오기
	List<Customer> findAll(@Param("startrow") int startrow,@Param("endrow") int endrow);
	//게시글 총개수
	int findByCount();

}
