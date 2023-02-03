<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ▼ home.jsp에서 가져옴, jstl 사용하려고 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>목록화면</h3>
	
	<!-- 인덱스번호 찍으려면 varStatus써서 그 안의 index찍어보면 됨 -->
	<c:forEach var="article" items="${list}" varStatus="num">
		${article.num }
		${article.name }
		${article.kor }
		${article.eng }
		<a href="delete?num=${article.num }">삭제</a> <!-- 원래 삭제는 post 방식임 -->
		<br/>
	</c:forEach>

</body>
</html>