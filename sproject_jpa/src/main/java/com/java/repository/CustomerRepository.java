package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Board;
import com.java.dto.Member;

//@Repository //생략가능 <Board,Integer> <리턴객체타입,객체Primary Key>
public interface CustomerRepository extends JpaRepository<Board, Integer> {

	//게시글1개 가져오기
	Object findByBno(int bno);

	
	@Modifying // update,delete쿼리를 실행할때 - 에러나는 경우가 있어 반드시 넣어줘야 함.
	@Transactional //여러개일때
	@Query(value="update board set bstep=bstep+1 where bgroup=:bgroup and bstep>:bstep",
	nativeQuery = true)
	void reply(@Param("bgroup") int bgroup,@Param("bstep") int bstep);


	@Modifying
	@Transactional
	@Query(value="update board set bhit = bhit+1 where bno=:bno", nativeQuery = true)
	void updateHit(@Param("bno") int bno);


	//이전글
	@Query(value="select * from board where bno = ( select preBno from (\r\n"
			+ "select bno,lag(bno,1,-1) over(order by bgroup desc,bstep asc) as preBno from board\r\n"
			+ ") a where bno = :bno )", nativeQuery = true)
	Board findPreBoard(@Param("bno") int bno);

	//다음글
	@Query(value="select * from board where bno = ( select preBno from (\r\n"
			+ "select bno,lead(bno,1,-1) over(order by bgroup desc,bstep asc) as preBno from board\r\n"
			+ ") a where bno = :bno )", nativeQuery = true)
	Board findNextBoard(@Param("bno") int bno);


	
	
}
