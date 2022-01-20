<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<title>공지사항 게시판</title>



<c:if test = ${boardDTO.auth}='관리자'>
	${boardDTO.subject}
	${boardDTO.auth}
	${boardDTO.content}
	${boardDTO.writer }
	${boardDTO.red_date}
</c:if>
