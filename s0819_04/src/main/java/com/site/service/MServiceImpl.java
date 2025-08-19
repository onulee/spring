package com.site.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.site.dto.Member;

@Service
public class MServiceImpl implements MService {

	static List<Member> list = new ArrayList<>();
	{
		list.add(new Member("aaa", "1111", "홍길동", "010-1111-1111", "남자", "게임,골프"));
		list.add(new Member("bbb", "2222", "유관순", "010-2222-2222", "여자", "수영,독서,조깅"));
		list.add(new Member("ccc", "3333", "이순신", "010-3333-3333", "남자", "게임,조깅"));
	}
	
    //변수종류 - 클래스변수,인스턴스변수,지역변수
	//메소드종류 - 클래스메소드,인스턴스메소드
	public Member selectOne() {
		//member 정보가 있음
		return list.get(0);
	}
	
	public List<Member> selectAll(){
		return list;
	}

	@Override
	public void insertOne(Member member) {
		list.add(member);
	}
	
	
}
