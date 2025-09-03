package com.java.service;

import com.java.dto.Reply;

public interface ReplyService {

	//하단댓글 저장
	Reply save(Reply r);

	//하단댓글 삭제
	void deleteById(int rno);

}
