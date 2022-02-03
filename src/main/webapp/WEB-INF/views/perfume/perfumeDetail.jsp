<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<table>
<c:forEach items="${getDetail}" var= "per"> 
<tr><td>게시물번호 :</td><td>${per.p_number}</td></tr>
<tr><td>향수사진 :</td><td>${per.f_pic}</td></tr>
<tr><td>향수번호 :</td><td>${per.f_number}</td></tr>
<tr><td>향수이름 :</td><td>${per.f_name}</td></tr>
<tr><td>탑노트 :</td><td>${per.topnote}</td></tr>
<tr><td>하트노트 :</td><td>${per.heartnote}</td></tr>
<tr><td>베이스노트 :</td><td>${per.basenote}</td></tr>
<tr><td>성별 :</td><td>${per.gender}</td></tr>
<tr><td>계절 :</td><td>${per.season}</td></tr>
<tr><td>탑노트번호 :</td><td>${per.topnote_num}</td></tr>
<tr><td>하트노트번호 :</td><td>${per.heartnote_num}</td></tr>
<tr><td>베이스노트번호 :</td><td>${per.basenote_num}</td></tr>
</c:forEach>
</table>