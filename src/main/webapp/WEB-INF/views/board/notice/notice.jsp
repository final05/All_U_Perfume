<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     

<title>공지사항 게시판</title>
<h1> 공지사항 게시판 </h1>

	<form action="/perfume/write" method="post">
		<input type = "submit" value = "글 쓰기" />
	</form>
	
	<input type = "button" value = "선택삭제" onclick="deleteValue();">


<table border = "1" >
	<tr>
		<th> 선택 </th>
		<th> 글번호 </th>
		<th> 글제목 </th>
		<th> 작성자 </th>
		<th> 작성일 </th>
		<th> 조회수 </th>
	</tr> 
		<c:forEach items="${list}" var="boardDTO" > 
		<tr>
		<td> <input name = "RowCheck" type = "checkbox" value="${boardDTO.b_number }" /></td>
		<td> ${boardDTO.b_number} </td>
		<td> <a href="/perfume/notice/noticeContent?b_number=${boardDTO.b_number}">${boardDTO.subject}</a> </td>
		<td> ${boardDTO.auth} </td>
		<td> ${boardDTO.reg_date} </td>
		<td> ${boardDTO.readcount} </td>
	</tr>
	</c:forEach>
</table>

	
