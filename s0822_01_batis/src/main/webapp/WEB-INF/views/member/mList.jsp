<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>전체회원리스트</title>
		<style>
		  h2{text-align: center;}
		  table{width:1200px; margin:10px auto; }
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  th,td{width:200px; height:40px; text-align: center;}
		</style>
	</head>
	<body>
	  <h2>전체회원리스트</h2>
	  <table>
	    <tr>
			<th>아이디</th>	      
			<th>패스워드</th>	      
			<th>이름</th>	      
			<th>전화번호</th>	      
			<th>성별</th>	      
			<th>취미</th>	      
	    </tr>
	    <c:forEach var="member" items="${list}">
		    <tr>
		        <td>
		          <a href="/member/mView?id=${member.id}">${member.id }</a>
		        </td>
		        <td>${member.pw }</td>
		        <td>${member.name }</td>
		        <td>${member.phone }</td>
		        <td>${member.gender }</td>
		        <td>${member.hobby }</td>
		    </tr>
	    </c:forEach>
	    
	    <tr>
	        <td colspan="6"><a href="/">메인페이지 이동</a></td>
	    </tr>
	  </table>
	
	</body>
</html>