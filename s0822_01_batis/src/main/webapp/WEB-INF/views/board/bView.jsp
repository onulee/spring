<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글상세보기</title>
		<style>
		  h2{text-align: center;}
		  table{width:400px; margin:10px auto; }
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  th,td{width:200px; height:40px; text-align: center;}
		</style>
	</head>
	<body>
	  <h2>게시글상세보기</h2>
	  <table>
	    <tr>
	      <th>번호</th>
	      <td>${board.bno}</td>
	    </tr>
	    <tr>
	      <th>제목</th>
	      <td>${board.btitle}</td>
	    </tr>
	    <tr>
	      <th>내용</th>
	      <td>${board.bcontent}</td>
	    </tr>
	    <tr>
	      <th>작성자</th>
	      <td>${board.id}</td>
	    </tr>
	    <tr>
	      <th>작성일</th>
	      <td>${board.bdate}</td>
	    </tr>
	    <tr>
	      <th>조회수</th>
	      <td>${board.bhit}</td>
	    </tr>
	    <tr>
	      <th colspan="2"><a href="/">메인페이지 이동</a></th>
	    </tr>
	  </table>
	
	</body>
</html>