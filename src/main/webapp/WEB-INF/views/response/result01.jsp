<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	String data = (String)request.getAttribute("data");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>result01 페이지</h3>
	<%-- <%= data %> --%>
	${data}<br/>
	${serverTime}

</body>
</html>