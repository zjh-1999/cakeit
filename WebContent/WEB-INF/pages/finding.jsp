<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="io.cakeit.entity.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Finding</title>
</head>
<body>
	<h1>查找列表</h1>
	<br>
	<br>
	<br>
	<%
		List<Menu> menulist = (List<Menu>) request.getAttribute("finding");
	%>
	<ul>
		<%
			for (Menu menu : menulist) {
		%>
		<li><a href="menuDetail?id=<%=menu.getId()%>"><img
				src=<%=menu.getImg()%> width="100"><%=menu.getTitle()%></a></li>
		<%
			}
		%>
	</ul>
</body>
</html>