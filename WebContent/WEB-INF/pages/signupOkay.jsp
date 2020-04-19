<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SignUp</title>
</head>
<body>
	<h1>注册</h1>
	<br>
	<br>
	<br>
	<%
		String msg = (String) request.getAttribute("signupmsg");
	%>
	<b> <%=msg%>
	</b>
	<br>
	<p>
		<a href="jumpToLogin">登录</a>
</body>
</html>