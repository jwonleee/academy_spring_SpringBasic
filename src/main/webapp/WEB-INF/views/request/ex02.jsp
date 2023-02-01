<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	ex02 화면
	
	<form action="doAction" method="post">
		이름: <input type="text" name="name">
		나이: <input type="number" name="age">
		
		<input type="checkbox" name="inter" value="1">java
		<input type="checkbox" name="inter" value="2">spring
		<input type="checkbox" name="inter" value="3">boot
		
		<input type="submit" value="확인">
	</form>

</body>
</html>