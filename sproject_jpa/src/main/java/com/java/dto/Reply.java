package com.java.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rno;
	
	@Column(length=100)
	private String rpw;
	
	@Column(nullable = false, length = 2000)
	private String rcontent;
	
	@ManyToOne               // 연관관계지정 - 1개의 게시글에는 여러개의 하단댓글사용
	@JoinColumn(name="bno")  // DB에 저장할때 컬럼 이름지정
	private Board board;  // Board.java연결 - db에는 객체저장이 안됨 
	
	@ManyToOne
	@JoinColumn(name="id")
	private Member member;
	
	@UpdateTimestamp 
	private Timestamp rdate;
	

}
