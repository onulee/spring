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
	private String btitle;
	private String bcontent;
	private String id;
	
	private int bgroup; //답변달기 그룹핑
	private int bstep;  //답변달기 출력순서
	private int bindent;//답반달기 드려쓰기
	
	private int bhit;
	private String bfile;
	private Timestamp bdate;
	
}
