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
	
	//답글달기
	private int bgroup;
	private int bstep;
	private int bindent;
	
	private String bhit;
	private String bfile;
	private Timestamp bdate;
}
