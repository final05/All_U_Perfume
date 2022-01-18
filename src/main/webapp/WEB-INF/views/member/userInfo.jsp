<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당신만의 향기, All U Perfume</title>
</head>
<body>

<img src="/resources/images/img/${MemberDTO.img}" width="100" />
<input type="button" value="사진 변경" onclick="window.location='/member/imgUpdate'" />
<br />

id : ${MemberDTO.id} <br />
name : ${MemberDTO.name} <br />	
birth : <fmt:formatDate value="${MemberDTO.birthday}" type="date" /> <br />
regdate : <fmt:formatDate value="${MemberDTO.regdate}" type="date" /> <br />

<input type="button" value="비밀번호 변경" onclick="window.location='/member/pwCheck?id=${sessionScope.id}'">
<input type="button" value="탈퇴" onclick="window.location='/member/delete'" />

</body>
</html>