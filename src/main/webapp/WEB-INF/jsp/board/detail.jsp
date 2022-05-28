<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/layout.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/board.css"/>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	
	$(document).ready(function(){
		
		$('#goListBtn').click(function(){
			
			location.href = "${pageContext.request.contextPath}/board"
		})
		
	})
	
	function modifyBoard(boardNo){
			location.href = 'modifyForm.jsp?no=' +boardNo ;
	}
	
	function deleteBoard(boardNo){
		if(confirm('정말 삭제하시겠습니까?'))
			location.href = 'delete.jsp?no=' +boardNo ;
	}
	
	/*
	function clickBtn(type){ // 교수님방법
		switch(type){
		case 'U' :
			location.href = "modify.jsp?no=${param.no}" // detail에서 no? 로 파라미터값 넘어오기 때문에 param.no 사용가능 
			break;
		case 'D' :
			if(confirm('[${param.no}]번 게시글을 삭제할까여?'))	
				location.href = 'delete.jsp?no=${param.no}'
			break;
		case 'L' :
			break;
		}
	}
	*/
	
	
	
	
	
</script>
</head>
<body>
	<header>
	<%-- 	<jsp:include page="/jsp/include/tobMenu.jsp" /> --%>
	</header>
	<section>
		<div align="center">
		<hr width="80%">
		<h2>게시판 상세</h2>
		<hr width="80%">
		<br>
		
		<table border="1" style="width: 80%">
			<tr>
				<th width="25%">번호</th>
				<td><c:out value="${ board.no }" /></td>
			</tr>
			<tr>
				<th width="25%">제목</th>
				<td><c:out value="${ board.title }" /></td>
			</tr>
			<tr>
				<th width="25%">작성자</th>
				<td><c:out value="${ board.writer }" /></td>
			</tr>
			<tr>
				<th width="25%">내용</th>
				<td><c:out value="${ board.content }" /></td>
			</tr>
			<tr>
				<th width="25%">조회수</th>
				<td><c:out value="${ board.viewCnt }" /></td>
			</tr>
			<tr>
				<th width="25%">등록일</th>
				<td><c:out value="${ board.regDate }" /></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<c:forEach items="${ fileList }" var="file">  <%-- 업로드 후, upload디렉토리 새로고침 해줘야함 --%>
						<a href="/Mission-Web/upload/${ file.fileSaveName }" download>
							<c:out value="${ file.fileOriName }" />
						</a>
						(${ file.fileSize } bytes)
						<br>
					</c:forEach>
				</td>
			</tr>
			
		</table>
		<br>
		<button onclick="modifyBoard('${board.no}')">수정</button>
		<button  onclick="deleteBoard('${board.no}')">삭제</button>
		<button id="goListBtn">목록</button>
		<%--button onclick="clickBtn('U')">수정</button> 교수님방법  --%> 
	</div>
	<div style="text-align: center">
	<hr>
	댓글 : <input type="text" name="comment" />
	작성자 : <input type="text" name="writer" />
	<button>댓글등록</button>
	</div>
	</section>
	<footer>
		<%-- <%@ include file="/jsp/include/bottom.jsp" %>  --%><%-- include는 경로가 프로젝트명(Mission-Web) 다음으로 정의됨 !!! --%>
	</footer>
</body>
</html>
