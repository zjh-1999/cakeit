<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,io.cakeit.entity.Item"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Item item = (Item) request.getAttribute("item");
	%>

	<h1>购物车</h1>
	<hr>
	<h2>Items to add</h2>
	<br>
	<div>
		<span><img src=<%=item.getIcon()%> width="210"> </span>
	</div>

	<b><%=item.getItemname()%>&nbsp;&nbsp;&nbsp;<%=item.getBrand()%></b><br>
	<b><%=item.getQuality()%>&nbsp;&nbsp;<%=item.getPrice()%></b><br>
	
	
	<form action="AddToCart" method="post">
	Count:<select name="count">
	<option value=1>1</option>
	<option value=2>2</option>
	<option value=3>3</option>
	<option value=4>4</option>
	</select>
	<input type="submit" value="Add">
	</form>
</body>
</html>