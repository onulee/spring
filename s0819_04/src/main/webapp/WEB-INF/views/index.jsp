<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
	  <h2>메인페이지</h2>
	  <ul>
	    <!-- jsp,html 데이터전달방법 : 
	      1.form  2.파라미터  3.pathValiable  4.ajax
	     -->
	    <li><a href="/member/member">회원가입</a></li>
	    <li></li>
	    <li><a href="/board/blist/1">1을 넘겨주는 게시판</a></li>
	    <li><a href="/board/blist">데이터가 없는 게시판</a></li>
	    <li><a href="/board/board?page=1">파라미터 값으로 전달 게시판</a></li>
	    <li><a href="/board/board">파라미터 값 없이 전달 게시판</a></li>
	  </ul>
	
	</body>
</html>