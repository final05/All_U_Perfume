<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All U Perfume 관리자 페이지입니다.</title>
</head>

<body>

<c:if test="${sessionScope.aid == null}">
	<script>
		alert("로그인 후 사용 가능합니다.");
		window.location="/admin/login";
	</script>
</c:if>

<c:if test="${sessionScope.aid != null}">
		관리자님, 환영합니다!
		<input type="button" value="테스트">
</c:if>

</body>
</html>