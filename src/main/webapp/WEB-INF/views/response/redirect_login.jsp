<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>redirect 사용해보기</h3>
	
	<form action="login" method="post">
		<input type="text" name="id">
		<input type="password" name="pw">
		<input type="submit" value="확인">
	</form>
	<h3>${msg }</h3>

</body>
</html>