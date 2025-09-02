package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Reply;
import com.java.repository.ReplyRepository;

@Transactional
@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired ReplyRepository replyRepository;
	
	@Override //하단댓글 저장
	public Reply save(Reply r) {
		Reply reply = replyRepository.save(r);
		return reply;
	}

	
}
