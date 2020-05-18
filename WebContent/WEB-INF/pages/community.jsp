<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,io.cakeit.entity.Article"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Community</title>
<style>
ul.a {list-style-type:square;}
</style>
</head>
<body>
<h3>有什么新鲜事想告诉大家?</h3>

<%
   Date date = new Date();


%>

	<form method="post" action="Community">
	<input type="text" name="title" size="70" maxlength="15" placeholder="标题，15字以内"><br>
	<br>
	<textarea name="content" rows="5" cols="60" maxlength="140" placeholder="内容，140字以内"></textarea><br>
	<br>
	<input type="hidden" name="releasetime" value="<%=date.toString()%>">
	<input type="submit" value="上传">
	</form>
	<br> 

	<a href="main">返回主页</a>
	<hr>
	<h3>Articles</h3>
<%
		ArrayList<Article> articles = (ArrayList<Article>) request.getAttribute("articles");
	%>

	<br>
	<ul>

		<%
			for (Article article : articles) {
		%>
		<ul class="a"><li>
		<%=article.getTitle()%><br>
		<%=article.getContent()%><br>
		<%=article.getReleasetime()%><br>
		
		<hr></li></ul>
		<%
			}
		%>
	</ul>
</body>
</html>