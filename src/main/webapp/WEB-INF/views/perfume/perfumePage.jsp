<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   


<style>
#menu{
 padding: 0px;
 margin: 0px;
 display : flex;
 height: 50vh;
 justify-content: left;
 align-items: left;
}
#perfumelist{
 padding: 0px;
 margin: 0px;
 display : flex;
 height: 0vh;
 justify-content: center;
 align-items: center;


}


#page {
position: fixed; 
bottom: 0; 
width: 100%; 
text-align: center;
}
		


</style>
  <h3>카테고리</h3> </br> 
 <div id="menu">

 <form action="/main/search" method="post">
 <input type = "text" name="keyword"/><input type="submit" value="검색"/></br>
 	
 	<ul>
 		<li><h4>성별</h4>
 			
 			<ul class="low">
 				<input type = "checkbox" name="c_gender" value="0">여성<br/>
 				<input type = "checkbox" name="c_gender" value="1">남성<br/>
 				<input type = "checkbox" name="c_gender" value="2">중성<br/>
 			</ul> 
 		</li>
 		
 		<li><h4>계절</h4>
 		
 			<ul class="low">
 			<input type = "checkbox" name="c_season" value="1">봄</br>
 			<input type = "checkbox" name="c_season" value="2">여름</br>
 			<input type = "checkbox" name="c_season" value="3">가을</br>
 			<input type = "checkbox" name="c_season" value="4">겨울</br>
 			</ul>
 		</li>
 		
 		<li><h4>노트</h4>
 		
 			<ul class="low">
 			<input type = "checkbox" name="note" value="1">시트러스</br>
 			<input type = "checkbox" name="note" value="2">과일/채소/견과류</br>
 			<input type = "checkbox" name="note" value="3">꽃</br>
 			<input type = "checkbox" name="note" value="4">흰 꽃</br>
 			<input type = "checkbox" name="note" value="5">허브류</br>
 			<input type = "checkbox" name="note" value="6">향신료</br>
 			<input type = "checkbox" name="note" value="7">달콤한 디저트향</br>
 			<input type = "checkbox" name="note"value="8">나무와 이끼류</br>
 			<input type = "checkbox" name="note" value="9">나무 진액</br>
 			<input type = "checkbox" name="note" value="10">동물에게 추출한 향기</br>
 			<input type = "checkbox" name="note" value="11">술</br>
 			<input type = "checkbox" name="note" value="12">그 외</br>
 			</ul>
 		</li>
 	</ul>
	</form>
</div>   

<div id="perfumelist">
<table border="1">
<tr><td>게시글 번호 </td><td>향수이름</td></tr>
<c:forEach items="${list}" var="PerfumeDTO">
<tr><td><a href="/main/detail?p_number=${PerfumeDTO.p_number}&f_name=${PerfumeDTO.f_name}">${PerfumeDTO.p_number}</a></td>
<td><a href="/main/detail?f_name=${PerfumeDTO.f_name}&p_number=${PerfumeDTO.p_number}">${PerfumeDTO.f_name}</a></td></tr>

</c:forEach>
</table>
</div>

<div id="page">
	<ul>
		<c:if test="${pageMaker.prev}">
			<a href="${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a>
		</c:if>
			
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			<a href="${pageMaker.makeQuery(idx)}">${idx}</a>	
		</c:forEach>
		
		<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
			<a href="list${pageMaker.makeQuery(pageMaker.endPage+1)}">다음</a>
		</c:if>
	</ul>

</div>