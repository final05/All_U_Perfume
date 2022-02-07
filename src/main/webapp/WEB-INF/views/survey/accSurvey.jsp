<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당신만의 향기, All U Perfume</title>
</head>

<body>

<script type="text/javascript">
var maxCount = 3
var count = 0;
	
	function threeCheck(field) {
		if(field.checked){
			count += 1;
		}else{
			count -= 1;
		}
		
		if(count > maxCount){
			alert("최대 3가지 향만 선택 가능합니다.");
			field.checked = false;
			count -= 1;
		}
	}

</script>


<form action="/survey/accResult" method="post"">
	원하시는 타입의 향을 3가지 골라주세요.
	<dl>
	<dt><b>노트</b></dt>
			<dd>
			<input onclick="threeCheck(this)" type = "checkbox" name="note_type_num" value="1">시트러스</br>
			<input onclick="threeCheck(this)" type = "checkbox" name="note_type_num" value="2">과일/채소/견과류</br>
			<input onclick="threeCheck(this)" type = "checkbox" name="note_type_num" value="3">꽃</br>
			<input onclick="threeCheck(this)" type = "checkbox" name="note_type_num" value="4">흰 꽃</br>
			<input onclick="threeCheck(this)" type = "checkbox" name="note_type_num" value="5">허브류</br>
			<input onclick="threeCheck(this)" type = "checkbox" name="note_type_num" value="6">향신료</br>
			<input onclick="threeCheck(this)" type = "checkbox" name="note_type_num" value="7">달콤한 디저트향</br>
			<input onclick="threeCheck(this)" type = "checkbox" name="note_type_num" value="8">나무와 이끼류</br>
			<input onclick="threeCheck(this)" type = "checkbox" name="note_type_num" value="9">나무 진액</br>
			<input onclick="threeCheck(this)" type = "checkbox" name="note_type_num" value="10">동물에게 추출한 향기</br>
			<input onclick="threeCheck(this)" type = "checkbox" name="note_type_num" value="11">술</br>
			<input onclick="threeCheck(this)" type = "checkbox" name="note_type_num" value="12">그 외</br>
			</dd>
	</dl>
	<input type="submit" value="결과 확인">
</form>

</body>
</html>