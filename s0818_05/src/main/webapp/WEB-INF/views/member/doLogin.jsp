<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		<style>
		  h2{text-align: center;}
		  table{width:400px; margin:10px auto;}
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  th,td{width:200px; height:40px; text-align: center; }
		</style>
	</head>
	<body>
	  <h2>로그인</h2>
	  <table>
	    <tr>
	      <th>아이디</th>
	      <td>${id}</td>
	    </tr>
	    <tr>
	      <th>패스워드</th>
	      <td>${pw}</td>
	    </tr>
	  </table>
	  <a href="/">메인페이지 이동</a>
	
	</body>
</html>