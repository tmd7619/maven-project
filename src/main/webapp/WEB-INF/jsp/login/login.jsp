<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/layout.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/board.css"/>
<script src="<%=request.getContextPath() %>/resources/js/myJS.js"></script>
<script>
	
	if('${msg}')
		alert('${msg}')



	/*
	function isNull(obj,msg){
		if(obj.value==''){
			alert(msg)
			obj.focus()
			return true
		}
		return false
	}
	*/
	
	function checkForm(){
		let f = document.loginForm
		
		if(isNull(f.id,'아이디를입력하세요')){
			return false
		}
		if(isNull(f.password,'비밀번호를입력하세요')){
			return false
		}
		
		/*
		if(f.id.value == ''){
			alert('아이디를 입력하세요')
			f.id.focus()
			return false;
		}
		if(f.password.value == ''){
			alert('패스워드를 입력하세요')
			f.password.focus()
			return false;
		}
		*/
		return true
	}
	
</script>

</head>
<body>
	<header>
		<%-- <jsp:include page="/jsp/include/tobMenu.jsp" /> --%>
	</header>
	<section>
		<div align="center">
			<hr>
			<h2>로그인</h2>
			<hr>
			<br>
				
			<form  method="post" name="loginForm" <%-- DB접근을 할경우 .do로 설정 --%>
			onsubmit="return checkForm()">
				<table>
					<tr>
						<th>ID</th>
						<td><input type="text" name="id"></td> <%-- name값이 파라미터로 날라감 --%>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="checkbox">아이디저장 <!-- 쿠키활용 -->
					</tr>
				</table>
				<br>
				<input type="submit" value="로그인">				
			
			</form>
		</div>
	</section>
	<footer>
		<%-- <%@ include file="/jsp/include/bottom.jsp" %> --%> <%-- include는 경로가 프로젝트명(Mission-Web) 다음으로 정의됨 !!! --%>
	</footer>
</body>
</html>