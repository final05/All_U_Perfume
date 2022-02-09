<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     

<title>Q&A 게시판</title>
<h1> Q&A 글 작성 </h1>
	<h2> 관리자만 글 쓰기 버튼이 뜨게 만들기 </h2>
<c:if test = "${sessionScope.aid != null }">
    <form action="/perfume/q_a/ReBoardWritePro" method="post">
    	<input type="hidden" name="boardnum" value="${Re_boardDTO.boardnum}">
		<input type="hidden" name="bno" value="${Re_boardDTO.bno}">
    	제 목 : <input type="text" name="subject" />
    	<input type ="hidden" name ="writer" value="${Re_boardDTO.writer}" />  <br />
    	내 용 : <textarea rows="10" cols="20" name="content"></textarea> <br />
    		   <input type="submit" value="글쓰기" />
    </form>
 </c:if>