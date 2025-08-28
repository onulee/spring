package com.java.dto;

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
@Entity
public class Member {
	
	@Id //primary key 등록
	private String id;
	@Column(nullable = false,length = 100)
	private String pw;
	@Column(nullable = false,length = 100)
	private String name;
	@Column(length = 20)
	private String phone;
	@ColumnDefault(" '남자' ")  //"0"
	private String gender;
	@Column(length = 100)
	private String hobby;
	@CreationTimestamp //sysdate 입력됨.
	private Timestamp mdate;

}
