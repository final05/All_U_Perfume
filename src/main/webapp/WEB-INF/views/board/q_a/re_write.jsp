<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     

<title>Q&A 게시판</title>
<h1> Q&A 글 작성 </h1>

     <form action="/perfume/q_a/re_writePro" method="post">
    	<input type="hidden" name="boardnum" value="${boardDTO.boardnum}">
		<input type="hidden" name="b_number" value="${boardDTO.b_number}">
		<input type="hidden" name="ref" value="${boardDTO.ref}">
		<input type="hidden" name="re_step" value="${boardDTO.re_step}">
		<input type="hidden" name="depth" value="${boardDTO.depth}">
		sfoofks'd;fl sdfksdfs d
		bnumber = ${boardDTO.b_number}
		regf = ${boardDTO.ref}
		sss= ${boardDTO.re_step}
		sss = ${boardDTO.depth}
		작성자 ? ${boardDTO.writer} ddd
    	제 목 : <input type="text" name="subject" /> 
    	<input type = "text" name = "writer" value = "${boardDTO.writer }">
    	<input type = "password" name = "password" value = "${boardDTO.password }">
    	내 용 : <textarea rows="10" cols="20" name="content"></textarea> <br />
    	첨부파일 : ${boardDTO.filename} <br /> 
    		   <input type="submit" value="글쓰기" />
    </form>