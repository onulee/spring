package com.site.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity //Member 테이블 생성
public class Member {
	@Id //primary key 등록
	private String id;
	@Column(nullable = false,length=50)  // pw varchar2(100) not null
	private String pw;
	@Column(nullable = false,length=100)
	private String name;
	@Column(nullable = true, length=30) // 010-1111-1111
	private String phone;
	@ColumnDefault(" '남자' ")   //gender varchar2(30) default '남자'  
	private String gender;
	@Column(length=100)
	private String hobby;
	@CreationTimestamp //시간이 자동으로 입력됨.
	private Timestamp mdate;
}
