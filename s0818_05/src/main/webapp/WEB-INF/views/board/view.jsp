<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판뷰</title>
		<style>
		  h2{text-align: center;}
		  table{width:400px; margin:10px auto;}
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  th,td{width:200px; height:40px; text-align: center; }
		</style>
	</head>
	<body>
	  <h2>게시판뷰</h2>
	  <table>
	    <tr>
	      <th>번호</th>
	      <td>${boardDto.bno}</td>
	    </tr>
	    <tr>
	      <th>제목</th>
	      <td>${boardDto.btitle}</td>
	    </tr>
	    <tr>
	      <th>작성자</th>
	      <td>${boardDto.id}</td>
	    </tr>
	    <tr>
	      <th>작성일</th>
	      <td>${boardDto.bdate}</td>
	    </tr>
	    <tr>
	      <th>조회수</th>
	      <td>${boardDto.bhit}</td>
	    </tr>
	  </table>
	  <a href="/">메인페이지 이동</a>
	
	</body>
</html>