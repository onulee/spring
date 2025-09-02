package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

}
