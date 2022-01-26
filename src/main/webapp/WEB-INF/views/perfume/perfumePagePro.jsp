<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
프로페이지</br>

<h1>${cate}</h1>
</br>
<c:forEach items="${cate}" var="cate">
${cate}
</c:forEach>

