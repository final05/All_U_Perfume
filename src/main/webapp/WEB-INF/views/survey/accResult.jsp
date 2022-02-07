<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${Tnote}" var="Tnote">
<a href="javascript:void(0);" onclick="window.open('/main/detail?p_number=${Tnote.p_number}&f_name=${Tnote.f_name}', 'pop01', 'top=10, left=10, width=500, height=600, status=no, menubar=no, toolbar=no, resizable=no');">
 <img src="${Tnote.f_pic}" width="100" height="200">
 ${Tnote.f_number}
 ${Tnote.f_name}
 </a>
<c:forEach items="${Tnote}" var="Tnote">
 ${Tnote.f_number}
  ${Tnote.f_name}
  <br/>
  <br/>
</c:forEach>


</body>
</html>