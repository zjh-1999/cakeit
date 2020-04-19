<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,io.cakeit.entity.*,io.cakeit.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu List</title>
</head>
<style>
* {
	padding: 10px;
	margin: 10px;
}

li {
	line-height: 40px;
}

#finding {
	width: 1000px;
	text-align: right;
}
</style>
<body>
	<%
		List<Menu> menulist = (List<Menu>) request.getAttribute("menulist");
	%>
	<h1>菜谱列表</h1>
	<br>
	<form method="post" action="finding" id="finding">
		<input type="text" name="find"> <input type="submit"
			value="查找">
	</form>
	<br>
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