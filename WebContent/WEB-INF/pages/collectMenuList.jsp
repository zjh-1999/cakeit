<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,io.cakeit.util.*,io.cakeit.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Collect Menu</title>
</head>
<body>
	<%
		List<Menu> collectmenulist = (List<Menu>) request.getAttribute("collectmenulist");
	%>
	<h1>收藏菜谱列表</h1>
	<br>
	<br>
	<ul>
		<%
		if(collectmenulist!=null){
			for (Menu menu : collectmenulist) {
		%>
		<li><a href="menuDetail?id=<%=menu.getId()%>"><img
				src=<%=menu.getImg()%> width="100"><%=menu.getTitle()%></a>&nbsp;&nbsp;&nbsp;<a href="collectMenuDelete?id=<%=menu.getId()%>">删除</a></li>
		<%
			}
		}
		else{
		%>
		<h1>未查询到结果</h1>
		<%} %>

	</ul>
</body>
</html>