package com.site.service;

import org.springframework.stereotype.Service;

import com.site.dto.Member;


public class MServiceImpl2 {

    //변수종류 - 클래스변수,인스턴스변수,지역변수
	//메소드종류 - 클래스메소드,인스턴스메소드
	public Member selectOne() {
		//member 정보가 있음
		Member member = new Member("bbb", "2222", "유관순", "010-2222-2222", "여자", "수영,독서,조깅");
		return member;
		
	}
	
	
}
