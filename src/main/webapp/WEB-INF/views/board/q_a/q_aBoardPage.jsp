<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<title>Q&A 게시판</title>
<h1> Q&A 게시판 </h1>

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
			var url = "delete_2"; // controller 로 보내고자 하는 url
			var valueArr = new Array();
			var q_a_list = $("input[name='RowCheck']");
			for (var i = 0; i < q_a_list.length; i++) {
				if(q_a_list[i].checked){ // 선택되어 있으면 배열에 값을 저장함 
					valueArr.push(q_a_list[i].value);
				}
			}
			if (valueArr.length == 0) { // 선택된 값이 0이면 = 배열에 저장된 값이 없으면
				alert("선택된 글이 없습니다.");
			} else { // 저장된 값이 있다면
				var chk = confirm ("정말 삭제하시겠습니까?");
				$.ajax({
					url : url, // 전송 url
					traditional : true,
					data : {
						valueArr : valueArr // 보내고자 하는 data 변수 설정
					},
					success: function(jdata) {
						console.log(jdata);
						if(jdata = 1) {
							alert("삭제 성공");
							location.replace("q_a_admin") // 리스트 페이지 샤로고침
						}
						else {
							alert("삭제 실패");
						}
					}
				});
			}
		}
	</script>
	


<c:if test ="${sessionScope.aid != null}" >
	<form action="/perfume/q_a/write" method="post">
		<input type = "submit" value = "글 쓰기" />
	</form>	
	<input type ="button" value = "선택삭제" onclick = "deleteValue();" >
</c:if>

<c:if test ="${paging.rowStart == 0 }">
	
	<th> 작성된 글이 없습니다. </th>

<table border = "1" >
	<tr>
		<th> <input id = "allCheck" type = "checkbox" name = "allCheck"/> </th>
		<th> 글번호 </th>
		<th> 글제목 </th>
		<th> 작성자 </th>
		<th> 작성일 </th>
		<th> 조회수 </th>
	</tr> 
		<c:forEach items="${q_a_list}" var="boardDTO" > 
		<tr>
		<td> <input name = "RowCheck" type = "checkbox" value="${boardDTO.b_number}"/></td>
		<td> ${boardDTO.b_number} </td>
		<td> <a href="/perfume/q_a/q_aContent?b_number=${boardDTO.b_number}">${boardDTO.subject}</a> </td>
		<td> ${boardDTO.auth} </td>
		<td> ${boardDTO.reg_date} </td>
		<td> ${boardDTO.readcount} </td>
	</tr>
	</c:forEach>
</table>


<div id="page">
	<ul>
		<c:if test="${pageMaker.prev}">
			<a href="${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a>
		</c:if>
			
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			<a href="${pageMaker.makeQuery(idx)}">${idx}</a>	
		</c:forEach>
		
		<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
			<a href="a_aBoardPage${pageMaker.makeQuery(pageMaker.endPage+1)}">다음</a>
		</c:if>
	</ul>

</div>
</c:if>