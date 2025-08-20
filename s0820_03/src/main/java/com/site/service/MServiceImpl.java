package com.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dao.MemberMapper;
import com.site.dto.Member;

@Service
public class MServiceImpl implements MService {

	@Autowired MemberMapper memberMapper;
	
	@Override //전체회원리스트
	public List<Member> selectAll() {
		List<Member> list = memberMapper.selectAll();
		return list;
	}

	@Override //로그인정보
	public Member selectLogin(String id, String pw) {
		System.out.println("selectLogin id : "+id);
		Member member = memberMapper.selectLogin(id,pw);
		return member;
	}

	@Override //회원상세보기
	public Member selectOne(String id) {
		Member member = memberMapper.selectOne(id);
		return member;
	}

}
