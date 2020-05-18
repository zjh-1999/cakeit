<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,io.cakeit.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>History</title>
</head>
<body>
<h1>历史浏览记录</h1><br><br>
	<%
		ArrayList<Menu> history = (ArrayList<Menu>) request.getAttribute("history");
		if (history != null) {
	%>
	<%
		for (Menu menu : history) {
	%>

	<li><a href="menuDetail?id=<%=menu.getId()%>"><img
			src=<%=menu.getImg()%> width="100"><%=menu.getTitle()%></a></li>
	<%
		}
		}
	%>
</body>
</html>