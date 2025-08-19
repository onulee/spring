<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생성적</title>
	</head>
	<body>
	  <h2>학생성적</h2>
	  <form action="/stu/stuInput" method="post">
	    <label>번호</label>
	    <input type="text" name="sno"><br>
	    <label>이름</label>
	    <input type="text" name="name"><br>
	    <label>국어</label>
	    <input type="text" name="kor"><br>
	    <label>영어</label>
	    <input type="text" name="eng"><br>
	    <label>수학</label>
	    <input type="text" name="math"><br>
	    <input type="submit" value="성적저장"><br>
	    
	  </form>
	  <ul>
	    <li><a href="/">메인페이지 이동</a></li>
	  </ul>
	
	</body>
</html>