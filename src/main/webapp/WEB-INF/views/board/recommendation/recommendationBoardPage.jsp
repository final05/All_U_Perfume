<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
    
<h1> 향수 추천 게시판 </h1>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type = "text/javascript">
		$(function(){
			var chkObj = document.getElementsByName("RowCheck");
			var rowCnt = chkObj.length;
			
			$("input[name='allCheck']").click(function(){
				var chk_listArr = ${"input[name='RowCheck']"};
				for (var i=0; i<chk_listArr.length; i++) {
					chk_listArr[i].checked = this.checked;
				}
			}) ;
			$("input[name='RowCheck']").click(function(){
				if($("input[name='RowCheck']:checked").length == rowCnt) {
					$("input[name='allCheck']")[0].checked = true;
				}
				else{
					$("input[name='allCheck']")[0].checked = false;
				}
			});
		});
		function deleteValue(){
			var url = "/admin/notice_admin_delete"; // controller 로 보내고자 하는 url
			var valueArr = new Array();
			var recommendation_list = $("input[name='RowCheck']");
			for (var i = 0; i < recommendation_list.length; i++) {
				if(recommendation_list[i].checked){ // 선택되어 있으면 배열에 값을 저장함 
					valueArr.push(recommendation_list[i].value);
				}
			}
			if (valueArr.length == 0) { // 선택된 값이 0이면 = 배열에 저장된 값이 없으면
				alert("선택된 글이 없습니다.");
			} else { // 저장된 값이 있다면
				var chk = confirm ("정말 삭제하시겠습니까?");
				$.ajax({
					url : url, // 전송 url
					traditional : true, // 배열갑 java로 전송하기
					data : {
						valueArr : valueArr // 보내고자 하는 data 변수 설정
					},
					success: function(jdata) {
						console.log(jdata);
						if(jdata == 1) {
							alert("삭제 성공");
							location.replace("notice_admin") // 리스트 페이지 샤로고침
						}
						else {
							alert("삭제 실패");
						}
					}
				});
			}
		}
	</script>
	sfsdfsdfsdfsdfsd
	${sessionSope.id }
	
	<c:if test = "${sessionSope.aid != null }">
    <form action="/perfume/recommendation/write" method="post">
        <input type = "submit" value = "글 쓰기" />
    </form>
    <input type = "button" value = "선택삭제" onclick="deleteValue();">
</c:if>

<c:if test = "${sessionSope.id != null }">
    <form action="/perfume/recommendation/write" method="post">
        <input type = "submit" value = "글 쓰기" />
    </form>
</c:if>



<table border = "1" >
	<tr>
		<th> 선택 </th>
		<th> 글번호 </th>
		<th> 글제목 </th>
		<th> 작성자 </th>
		<th> 작성일 </th>
		<th> 조회수 </th>
	</tr> 
		<c:forEach items="${recommendation_list}" var="boardDTO" > 
		<tr>
		<td> <input name = "RowCheck" type = "checkbox" value="${boardDTO.b_number }" /></td>
		<td> ${boardDTO.b_number} </td>
		<td> <a href="/perfume/recommendation/recommendationContent?b_number=${boardDTO.b_number}">${boardDTO.subject}</a> </td>
		<td> ${boardDTO.writer} </td>
		<td> ${boardDTO.reg_date} </td>
		<td> ${boardDTO.readcount} </td>
	</tr>
	</c:forEach>
</table>

	<form action = "/perfume/recommendation/list" method = "post">
		<div id ="search">
			<button type = "submit"> 검색 </button>
			<input type = "text" name = "searchName">
			<select class = "search-select" name = "searchType">
				<option value = "subject"> 제목 </option>
				<option value = "contetn"> 내용 </option>
				<option value = "writer"> 작성자 </option>
				<option value = "titcont"> 제목 + 내용 </option>
			</select>
		</div>
		<input type = "hidden" name = "pageNum" value = "1">
		<input type = "hidden" name = "amount" value = "10">
	</form>
	
<div id="page">
	<ul>
		<c:if test="${pageMaker.prev}">
			<a href="${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a>
		</c:if>
			
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			<a href="${pageMaker.makeQuery(idx)}">${idx}</a>	
		</c:forEach>
		
		<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
			<a href="recommendation_admin${pageMaker.makeQuery(pageMaker.endPage+1)}">다음</a>
		</c:if>
	</ul>

</div>