<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add Menu</title>
</head>
<body>
	<h1>上传我的菜谱</h1>
	<form method="post" action="uploadMenu" enctype="multipart/form-data">
		标题:<input type="text" name="title"><br>
		<br> 封面图片:<input type="file" name="img"><br>
		<br> 材料:
		<textArea rows=5 cols=50 name="material"></textArea>
		<br>
		<br> 步骤:
		<textArea rows=10 cols=50 name="step"></textArea>
		<br>
		<br> 简易程度:<input type="radio" name="level" value="简单">简单&nbsp;&nbsp;
		<input type="radio" name="level" value="中等">中等&nbsp;&nbsp; <input
			type="radio" name="level" value="困难">困难<br>
		<br> <input type="submit" value="提交">
	</form>
</body>
</html>