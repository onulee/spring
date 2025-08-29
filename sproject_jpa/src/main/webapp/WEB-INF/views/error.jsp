<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>에러페이지</title>
		<style>
		  div{margin-top:80px; text-align: center;}
		</style>
	</head>
	<body>
		<div>
			<a href="/">
			  <span>${message}</span>
			  <br><br>
			  <img src='/images/error.jpg'>
			</a>
		</div>
	
	</body>
</html>