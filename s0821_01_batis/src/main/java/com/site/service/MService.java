package com.site.service;

import com.site.dto.Member;

public interface MService {

	Member findByIdAndPw(String id, String pw);

}
