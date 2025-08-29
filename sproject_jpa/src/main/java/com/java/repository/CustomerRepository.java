package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.Board;

//@Repository //생략가능 <Board,Integer> <리턴객체타입,객체Primary Key>
public interface CustomerRepository extends JpaRepository<Board, Integer> {

	//게시글1개 가져오기
	Object findByBno(int bno);

	
	
}
