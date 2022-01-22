<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     

<title>공지사항 게시판</title>
<h1> 공지사항 글 작성 </h1>

    <form action="perfume/writePro" method="post">
    	제 목 : <input type="text" name="subject" /> <br />
    	작성자 : ${boardDTO.auth} 관리자 <br />
    	내 용 : <textarea rows="10" cols="20" name="content"></textarea> <br />
    		   <input type="submit" value="글쓰기" />
    </form>