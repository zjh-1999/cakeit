<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,io.cakeit.entity.*,io.cakeit.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		Cart cart = (Cart) session.getAttribute("cart");
		ArrayList<Item> items = cart.getItem();
	%>
	<%
		float fsum = 0;
	%>
	<h1>Check Out Page</h1>
	<hr>

	<ul>
		<%
			for (Item item : items) {
		%>

		<li><img src=<%=item.getIcon()%> width=80>&nbsp;&nbsp;<%=item.getId()%>&nbsp;&nbsp;<%=item.getItemname()%>&nbsp;&nbsp;<%=item.getPrice()%>&nbsp;&nbsp;<%=item.getCount()%>&nbsp;&nbsp;<%=item.getSum()%></li>
		<%
			fsum = fsum + item.getSum();
		%>
		<%
			}
		%>
	</ul>
	<hr>
	<h3>sum:</h3>
	<b><%=fsum%></b>


	<a href="ItemList">Back to List</a><br>

	<a href="OrderForm">Confirm</a>



</body>
</html>