package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired JavaMailSender mailSender;
	
	@Override // 이메일전송 구현
	public void emailSend(String email) {
		String pwCode = getCreateKey();
		System.out.println("랜덤번호 : "+ pwCode);
		
	}
	
	
	// 랜덤번호 생성 메소드
	public String getCreateKey() {
		String pwCode = "";
		char[] charSet = new char[] {
				'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F','G','H','I','J',
				'K','L','M','N','O','P','Q','R','S','T',
				'U','V','W','X','Y','Z'
		};
		String stringSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		int idx = 0;
		for(int i=0;i<10;i++) {
			idx = (int)(Math.random()*36);
			pwCode += charSet[idx];
		}
		return pwCode;
	}
	
	
	
	

	

}
