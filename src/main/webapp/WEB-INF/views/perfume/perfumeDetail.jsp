<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


게시글 번호 : ${p_number}


<c:if test="${f_name != null}">
향수 이름: <c:out value="${PerfumeDTO.f_number}"/>
</c:if>
    