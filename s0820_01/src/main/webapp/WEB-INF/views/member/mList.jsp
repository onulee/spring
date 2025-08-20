<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보리스트</title>
		<style>
		  h2{text-align: center;}
		  table{width:1200px; margin:10px auto; }
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  th,td{width:200px; height:40px; text-align: center;}
		</style>
	</head>
	<body>
	  <h2>회원정보리스트</h2>
	  <table>
	    <tr>
			<th>아이디</th>	      
			<th>패스워드</th>	      
			<th>이름</th>	      
			<th>전화번호</th>	      
			<th>성별</th>	      
			<th>취미</th>	      
	    </tr>
	    <tr>
	        <td></td>
	        <td></td>
	        <td></td>
	        <td></td>
	        <td></td>
	        <td></td>
	    </tr>
	    <tr>
	        <td colspan="6"><a href="/">메인페이지 이동</a></td>
	    </tr>
	  </table>
	  
	</body>
</html>



