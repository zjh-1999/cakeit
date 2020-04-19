<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,io.cakeit.entity.*,io.cakeit.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu Detail</title>
<style>
* {
	padding: 10px;
	margin: 10px;
}

div {
	line-height: 40px;
}
</style>
</head>
<body>
	<%
		Menu menu = (Menu) request.getAttribute("menu");
	%>
	<h1>详细菜谱</h1>
	<br>
	<br>
	<br>
	<div>
		<span><img src=<%=menu.getImg()%> width="200"></span>
	</div>
	<div><%=menu.getTitle()%><br>难易程度:<%=menu.getLevel()%><br>浏览次数:<%=menu.getViewtimes()%><br>
		材料:<%=menu.getMaterial()%><br>步骤:<%=menu.getStep()%><br>
	</div>
	<div><a href="collect">收藏该菜谱</a></div>
</body>
</html>