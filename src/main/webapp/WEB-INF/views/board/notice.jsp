<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     

<title>공지사항 게시판</title>
<h1> 공지사항 게시판 </h1>

	<c:forEach items="${list}" var="boardDTO" >
	글 번호 : ${boardDTO.b_number} |
	<a href="/perfume/noticeContent?b_number=${boardDTO.b_number}">${boardDTO.subject}</a> |
	작성자 : ${boardDTO.auth} |
	작성일 : ${boardDTO.reg_date} |
	조회수 : ${boardDTO.readcount} |
	<br />
</c:forEach>