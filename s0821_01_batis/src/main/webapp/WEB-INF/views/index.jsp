<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>메인페이지</title>
	<script>
		   if("${flag}"=="1"){
			   alert("로그인이 되었습니다.");
		   }
		</script>
	</head>
	<body>
	 <h2>메인페이지</h2>
	 <ul>
	   <li><a href="/member/login">로그인</a></li>
	   <li><a href="/member/mWrite">회원가입</a></li>
	   <li><a href="/member/mList">회원리스트</a></li>
	 </ul>
	
	</body>
</html>