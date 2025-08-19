<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
	</head>
	<body>
	  <h2>회원가입</h2>
	  <form action="/member/member" method="post">
	    <label>아이디</label>
	    <input type="text" name="id"><br>
	    <label>패스워드</label>
	    <input type="text" name="pw"><br>
	    <label>이름</label>
	    <input type="text" name="name"><br>
	    <label>전화번호</label>
	    <input type="text" name="phone"><br>
	    <label>성별</label><br>
	    <input type="radio" name="gender" id="남자" value="남자">
	    <label for="남자">남자</label>
	    <input type="radio" name="gender" id="여자" value="여자">
	    <label for="여자">여자</label><br>
	    <label>취미</label><br>
	    <input type="checkbox" name="hobby" id="게임" value="게임">
	    <label for="게임">게임</label>
	    <input type="checkbox" name="hobby" id="골프" value="골프">
	    <label for="골프">골프</label>
	    <input type="checkbox" name="hobby" id="수영" value="수영">
	    <label for="수영">수영</label>
	    <input type="checkbox" name="hobby" id="독서" value="독서">
	    <label for="독서">독서</label>
	    <input type="checkbox" name="hobby" id="조깅" value="조깅">
	    <label for="조깅">조깅</label><br>
	    
	    <input type="submit" value="회원가입"><br>
	    
	  </form>
	  <ul>
	    <li><a href="/">메인페이지 이동</a></li>
	  </ul>
	
	</body>
</html>