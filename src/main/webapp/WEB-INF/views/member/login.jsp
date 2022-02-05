<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당신만의 향기, All U Perfume</title>
</head>
<body>

	<form action="/member/loginPro" method="post">
		id: <input type="text" name="id"/> <br/>
		pw: <input type="password" name="pw"/> <br/>
			<input type="submit" value="로그인"> <br/>
		아직 회원이 아니신가요? <input type="button" value="회원가입 하러가기" onclick="window.location='/member/register'" />
	</form>

<a href="javascript:kakaoLogin();"><img src="/resources/images/kakao_login_medium_wide.png" alt="카카오계정 로그인" style="height: 50px;"/></a></br>
<a href="javascript:kakaoLogout();"/>
<input type="button" value="로그아웃 하기" onclick="window.location='javascript:kakaoLogout();'" />

<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
//b39601cdde217504460c15ddd71b1b47
Kakao.init('b39601cdde217504460c15ddd71b1b47'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
    	scope : 'profile_nickname, profile_image, account_email, gender, birthday',
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response)
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  	window.location = "/member/login";
  }
//카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }  
</script>
    
</body>
</html>