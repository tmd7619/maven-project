<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글등록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/board.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/layout.css"/>
<style type="text/css">
	.error {
		color: red
	}

</style>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>	

/* 	if('${ userVO }' == '') {
		location.href = "/Mission-Web/jsp/login/login.jsp"
	} */

	$(document).ready(function() {
		$('#goListBtn').click(function() {
			location.href = "${pageContext.request.contextPath}/board"

		})
	})

</script>
</head>
<body>
	<header>
		<%-- <jsp:include page="/jsp/include/tobMenu.jsp" /> --%>
	</header>
	<section>
		<div align="center">
			<hr width="80%">
			<h2>게시글 등록폼</h2>
			<hr width="80%">
			<br>
			<form:form method="post" modelAttribute="boardVO"> <!--  5버전은 modelAttribute 4버전 미만은 commandName  -->
				<table border="1" style="width:100%;">
				<tr>
					<th width="25%">제목</th>
					<td>
						<form:input path="title" />
						<form:errors path="title" class="error"/>
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<form:input path="writer" />
						<form:errors path="writer" class="error"/>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<form:textarea rows="8" cols="60" path="content"/>
						<form:errors path="content" class="error"/>
					</td>
				</tr>
				</table>
				<form:button type="submit">등록</form:button>
			</form:form>
		</div>
	</section>
	<footer>
		<%-- <%@ include file="/jsp/include/bottom.jsp"%> --%><%-- include는 경로가 프로젝트명(Mission-Web) 다음으로 정의됨 !!! --%>
	</footer>
</body>
</html>

