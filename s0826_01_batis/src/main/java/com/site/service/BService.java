package com.site.service;

import java.util.List;
import java.util.Map;

import com.site.dto.Board;

public interface BService {

	//게시글 모두 가져오기
	Map<String, Object> findAll(int page);

}
