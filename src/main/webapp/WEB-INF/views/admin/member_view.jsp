<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     

<title>회원 강제 탈퇴 페이지</title>


<form action="memeber_view_pro" method = "post" >
	회원 아이디 : <input type = "text" name = "user_id" placeholder="  탈퇴시킬 회원의 아이디를 입력하세요."> <br/>
	<input type = "submit" value = "회원 강제 탈퇴" /><br/>
	
	<!--  id 유효성 검사 -->
</form>
