<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당신만의 향기, All U Perfume</title>
<link rel="stylesheet" href="/resources/css/survey.css">
</head>
<body>
<c:if test="${sessionScope.id == null && sessionScope.kid == null}">
	<script>
		alert("로그인 후 사용 가능합니다.");
		window.location="/member/login";
	</script>
</c:if>
<script>
    function abs2(season){
        window.location.href="/survey/absSurvey3?gender=${absSurveyDTO.gender}&season="+season;
    }
</script>
<div class="header">향수를 사용할 계절을 골라주세요</div>
    <div class="body">
        <div class="content">
        	<c:forEach items="${second}" var="absSurvey2" varStatus="status" step="1" begin="0">				
		    	<div class="box1" >
		        	<div class="imagebox">
		           		<img class="image" src="/resources/images/survey/${absSurvey2.season}.jpg" onclick="abs2('${absSurvey2.season}')" >
		           	</div>
		           	${absSurvey2.survey}
		        </div>
		        
			</c:forEach>
   		</div>
    </div>
<div class="footer"></div>


</body>
</html>