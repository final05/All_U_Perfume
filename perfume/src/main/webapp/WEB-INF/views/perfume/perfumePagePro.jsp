<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
프로페이지</br>

<style>
#page {
position: fixed; 
bottom: 0; 
width: 100%; 
text-align: center;
}

</style>

<table border="1">
<tr><td>게시글 번호 </td><td>향수이름</td></tr>
<c:forEach items="${cate}" var="catee">
<tr><td><a href="/main/detail?p_number=${catee.p_number}&f_name=${catee.f_name}&page=${pa.page}&perPageNum=${pa.perPageNum}">${catee.p_number}</a></td>
<td><a href="/main/detail?p_number=${catee.p_number}&f_name=${catee.f_name}&page=${pa.page}&perPageNum=${pa.perPageNum}">${catee.f_name}</a></td></tr>
</c:forEach>
</table>


