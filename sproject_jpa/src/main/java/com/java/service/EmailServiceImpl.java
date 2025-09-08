package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired JavaMailSender mailSender;
	
	@Override // 이메일전송 구현
	@Async    // 비동기 방식으로 전환
	public void emailSend(String email) {
		String pwCode = getCreateKey();
		System.out.println("랜덤번호 : "+ pwCode);
		// 네이버 이메일 발송구현
		// TEXT로 메일 발송
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(email); // 보내는 주소
//		message.setFrom("onulee@naver.com"); //네이버이메일->네이버메일 에러가 남.
//		message.setSubject("제목입니다.");  // 메일 제목
//		message.setText("내용입니다. 랜덤번호 : "+pwCode+"\n"+
//		"[ 서비스를 이용해주셔서 감사합니다. ]");  // JavaMailSender 글자전송만 가능
//		mailSender.send(message);
//		System.out.println("이메일 전송이 완료되었습니다.");
//		
        //--------------------------------------------------------		
		// html코드로 메일 전송
		MimeMessage mmessage = mailSender.createMimeMessage();
		try {
			mmessage.setSubject("[안내] 홍길동 님 회원가입 임시번호를 발송했습니다.","UTF-8");
			String htmlCode = "<h2> 회원가입 임시 번호 </h2>"+
			"<div>임시번호 : <span style='color:red'>"+pwCode+"</span></div>";
			mmessage.setText(htmlCode,"utf-8","html");
			mmessage.setFrom(new InternetAddress("onulee@naver.com"));
			mmessage.addRecipient(RecipientType.TO, new InternetAddress(email));
			mailSender.send(mmessage);
			System.out.println("html 이메일 발송이 완료되었습니다.");
		} catch (Exception e) {e.printStackTrace();}
		
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
