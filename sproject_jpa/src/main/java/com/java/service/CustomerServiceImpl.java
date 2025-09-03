package com.java.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.dto.Member;
import com.java.repository.CustomerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired CustomerRepository customerRepository;
	//영속성 컨텍스트 - 시퀀스 파일
//	@PersistenceContext private EntityManager entityManager; 
	
	
	@Override //게시글 전체가져오기 - 현재페이지, 페이지당 개수
	public Page<Board> findAll(Pageable pageable) {
		Page<Board> pageList = customerRepository.findAll(pageable);
		return pageList;
	}
	
	
	@Override //게시글 전체가져오기 - 정렬 : bgroup역순정렬, bstep순차정렬
	public List<Board> findAll(Sort sort) {
//		Sort sort = Sort.by("id").descending();
		List<Board> list = customerRepository.findAll(sort);
		return list;
	}

	@Override
	public Map<String, Object> findByBno(int bno) {
		// 조회수 1증가
		customerRepository.updateHit(bno);
		// .get():에러처리안함 .orElseGet():빈객체처리 .roElseThrow():예외처리
		Board board = customerRepository.findById(bno).orElseThrow(
		 () -> { 
			return new IllegalArgumentException("해당되는 게시글이 존재하지 않습니다."); 
		 }
		);
		// 이전글
		Board preBoard = customerRepository.findPreBoard(bno);
		// 다음글
		Board nextBoard = customerRepository.findNextBoard(bno);
		Map<String, Object> map = new HashMap<>();
		map.put("board", board);
		map.put("preBoard", preBoard);
		map.put("nextBoard", nextBoard);
		return map;
	}

	@Override //게시글삭제
	public void deleteById(int bno) {
		customerRepository.deleteById(bno); //기본메소드
	}

	@Transactional  // 1번째부터 마지막까지 정상적으로 완료되어야 최종DB에 저장시켜줌
	@Override //글쓰기 저장
	public void save(Board b) {
		Board board = customerRepository.save(b);
		System.out.println("시퀀스 bno : "+b.getBno());
		// bgroup - 시퀀스번호를 입력
		b.setBgroup(b.getBno()); 
		b.setBdate(new Timestamp(System.currentTimeMillis()));
//		b.setBstep(0); //default 0
//		b.setBindent(0);
//		b.setBhit(0);
		
		// entityManager 사용방법
//		entityManager.persist(b); // 1차캐쉬 - 임시적으로 파일저장
//		System.out.println("시퀀스 bno : "+b.getBno());
//		// bgroup - 시퀀스번호를 입력
//		b.setBgroup(b.getBno()); 
//		b.setBstep(0);
//		b.setBindent(0);
//		b.setBhit(0);
//		b.setBfile("");
//		b.setBdate(new Timestamp(System.currentTimeMillis()));
//		customerRepository.save(b); //기본메소드
	}


	@Override // 답변달기 저장
	public void reply(Board b) {
		// 기존의 답변달기 되어 있는 게시글의 bstep을 모두 1증가 시켜줘야 함.
		//update board set bstep=bstep+1 where bgroup=#{bgroup} and bstep>#{bstep}
		customerRepository.reply(b.getBgroup(),b.getBstep());
		
		b.setBstep(b.getBstep()+1);
		b.setBindent(b.getBindent()+1);
		customerRepository.save(b);
		
	}

	

}
