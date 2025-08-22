package com.site.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {

	private int bno;        
	private String btitle; //제목
	private String bcontent; //내용
	private String id;
	
	//게층형게시판 - 답변달기
	private int bgroup;  //답변달기 그룹핑
	private int bstep;   //답변달기 출력순서
	private int bindent; //답변달기 드려쓰기
	
	private int bhit;
	private String bfile;
	private Timestamp bdate; 
	
}
