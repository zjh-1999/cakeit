<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SignUp</title>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>发布</h1>
	<hr><br>
	<%
		String msg = (String) request.getAttribute("releasemsg");
	%>
	<b>
		<%=msg%>
	</b>
	<br>
	<p>
	<a href="Community">BACK</a>

</body>
</html>