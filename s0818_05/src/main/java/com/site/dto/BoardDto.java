package com.site.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Setter
//@Getter
@Data  //Getter,Setter
@Builder            //부분생성자
@AllArgsConstructor //전체생성자
@NoArgsConstructor  //기본생성자
public class BoardDto {
	
	private int bno;
	private String btitle;
	private String bcontent;
	private int bgroup;
	private int bstep;
	private int bindent;
	private int bhit;
	private Date bdate;
	private String bfile;
	
}
