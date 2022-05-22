<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/board.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/layout.css"/>
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#addBtn').click(function() {
                location.href = "writeForm.jsp" // location 객체에 url정보가 담겨져 있다.
            })
        })

        /*
            자바스크립트는 웹브라우저가 해석, JSTL은 서버가 해석
            해석 순서는 서버가 웹브라우저보다 먼저 됨
            choose태그중 조건에 맞는 태그만 서블릿으로 해석됨
            웹브라우저 해석 시, 해석된 서블릿코드만 보여지게 됨
            자바스크립트에 jstl을 쓸때에는, 오타 error를 조심해야 함(error 못잡음)
        */
        function doAction(boardNo){
            <c:choose>
            <c:when test="${not empty userVO}">
            location.href = 'detail.jsp?no=' +boardNo + '&type=list'; // list에서 호출됐다라는 것을 알려주기 이해 &~ 씀
            </c:when>
            <c:otherwise>
            if(confirm('로그인이 필요한 서비스입니다. \n 로그인 페이지로 이동하시겠습니까?'))
                location.href = "/Mission-Web/jsp/login/login.jsp"
            </c:otherwise>
            </c:choose>

        }
    </script>
</head>
<body>
<header>
    <%-- <jsp:include page="/jsp/include/tobMenu.jsp" /> --%>
</header>
<section>
    <div align="center">
        <hr width="80%">
        <h2>게시판 목록</h2>
        <hr width="80%">
        <br>
        <table border="1" id="list">
            <tr>
                <th width="7%">번호</th>
                <th>제목</th>
                <th width="16%">작성자</th>
                <th width="20%">등록일</th>
            </tr>
            <c:forEach items="${boardList }" var="board" varStatus="loop">
                <tr <c:if test="${loop.index mod 2 ne 0 }"> class="odd"</c:if>>
                    <td><c:out value="${board.no }" /></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/board/${board.no}"> <%--rest방식 사용 --%>
                                <%-- 	<a href="${pageContext.request.contextPath}/board/detail?no=${board.no}">  --%>
                            <c:out value="${board.title }" />
                        </a>

                    </td>
                    <td><c:out value="${board.writer }" /></td>
                    <td><c:out value="${board.regDate }" /></td>
                </tr>
            </c:forEach>

        </table>
        <br>
        <c:if test="${not empty userVO }">
            <button id="addBtn">새글등록</button>
        </c:if>
    </div>
</section>
<footer>
    <%-- 	<%@ include file="/jsp/include/bottom.jsp" %>  --%><%-- include는 경로가 프로젝트명(Mission-Web) 다음으로 정의됨 !!! --%>
</footer>
</body>
</html>
