<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>
	.hidden{display:none;}
</style>

<table align = "center">
<c:forEach items="${getDetail}" var= "per"> 
<tr><td>게시물번호 :</td><td>${per.p_number}</td></tr>
<tr><td><img src="${per.f_pic}" width="100" height="200"></td></tr>
<tr><td>향수번호 :</td><td>${per.f_number}</td></tr>
<tr><td>향수이름 :</td><td>${per.f_name}</td></tr>
<tr><td>탑노트 :</td><td>${fn:replace(per.topnote,'-','&comma;')}</td></tr>
<tr><td>하트노트 :</td><td>${fn:replace(per.heartnote,'-','&comma;')}</td></tr>
<tr><td>베이스노트 :</td><td>${fn:replace(per.basenote,'-','&comma;')}</td></tr>
<tr><td>성별 :</td>
<td><c:choose>
<c:when test="${per.gender == 0}">
여자
</c:when>
<c:when test="${per.gender == 1}">
남자
</c:when>
<c:when test="${per.gender == 2}">
중성
</c:when>
</c:choose>
</td></tr>
<tr><td>계절 :</td>
<td><c:choose>
<c:when test="${per.season == 1}">
봄
</c:when>
<c:when test="${per.season == 2}">
여름
</c:when>
<c:when test="${per.season == 3}">
가을
</c:when>
<c:when test="${per.season == 4}">
겨울
</c:when>
</c:choose>
</td></tr>
<tr class="hidden"><td>탑노트번호 :</td><td>${per.topnote_num}</td></tr>
<tr class="hidden"><td>하트노트번호 :</td><td>${per.heartnote_num}</td></tr>
<tr class="hidden"><td>베이스노트번호 :</td><td>${per.basenote_num}</td></tr>
</c:forEach>
</table>

<input type="hidden" name ="page" value="${pa.page}"/>
<input type="hidden" name ="perPageNum" value="${pa.perPageNum}"/>