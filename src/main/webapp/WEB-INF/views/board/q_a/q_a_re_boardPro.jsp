<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
    
    <c:if test="${result == 1}">
	<script>
		alert("글쓰기 완료");
		window.location="/perfume/q_a/list";
	</script>
	</c:if>