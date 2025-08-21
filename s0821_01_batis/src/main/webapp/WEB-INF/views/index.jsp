<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>메인페이지</title>
	<script>
		   if("${flag}"=="1"){
			   alert("로그인이 되었습니다.");
		   }else if("${flag}"=="2"){
			   alert("로그아웃 되었습니다.");
		   }
	</script>
	</head>
	<body>
	 <h2>메인페이지</h2>
	 <ul>
	   <c:if test="${session_id == null }">
	      <h3>로그인을 하셔야 더 많은 서비스를 받을수 있습니다.</h3>
	      <li><a href="/member/login">로그인</a></li>
	   </c:if>
	   <c:if test="${session_id != null }">
	      <h3>로그인성공 : ${session_name} 님 환영합니다.</h3>
	      <li><a href="/member/logout">로그아웃</a></li>
	   </c:if>
	   <li><a href="/member/mWrite">회원가입</a></li>
	   <li><a href="/member/mList">회원리스트</a></li>
	 </ul>
	
	</body>
</html>