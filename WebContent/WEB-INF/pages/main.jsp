<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,io.cakeit.util.*,io.cakeit.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cake It</title>
<style>
* {
	paddng: 0;
	margin: 0;
}

#header {
	width: 1200px;
	height: 450px;
	background-size: 100%;
	background-image: url("./img/header.jpg");
	background-repeat: no-repeat;
}

#login {
	width: 1100px;
	margin: 0px 10px 10px 10px;
	text-align: right;
}

#navbar {
	width: 600px;
	margin: 150px auto 50px;
	font-size: 0;
	text-align: center;
}

#navbar a {
	display: inline-block;
	width: 80px;
	height: 30px;
	font-size: 20px;
	text-align: center;
	line-height: 30px;
	text-decoration: none;
	border-bottom: 1px solid #ccc;
}

#header a:link {
	color: white;
}

#navbar a:hover {
	color: white;
	background-color: #ccc;
	border: 1px solid;
	border-left-color: yellow;
	border-right-color: yellow;
	border-top-color: yellow;
}

#header a:visited {
	color: white;
}

.picright {
	text-align: right;
}

img {
	height: 200px;
	margin-left: 40px;
}

#introduce {
	paddng: 30px;
	margin: 30px 90px;
	line-height: 35px;
	font-size: 15px;
}

#intro {
	width: 450px;
	display: inline-block;
}

#recommend {
	background-image: url("./img/recommend.png");
	background-size: 100%;
	background-repeat: no-repeat;
}
</style>

</head>
<body>
	<div id="header">
		<div id="login">
			<br> <a href="jumpToLogin">登录</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
				href="jumpToSignup">注册</a>
		</div>
		<div id="navbar">
			<a href="introduce">入门</a> <a href="menuList">菜谱</a> <a href="#">社区</a>
			<a href="#">购买</a> <a href="my">我的</a>
		</div>
	</div>
	<div id="introduce">
		<div id="intro">
			烘焙的世界神奇而绚丽，吸引了一波又一波的人来朝圣。食物最美的时刻，是在烤箱里迸发的一瞬间，这时候，食物仿佛有了生命力，展现出其最美的姿态，“叮”的一声就可以看见热气腾腾、飘着香味的美食。享受着出自自己之手的美食，刺激着味蕾和感觉神经，在心中留下了特别的味道。在这里，我们就一起来感受一下美食的魅力吧！<br>
			<a href="introduce">新手请点击这里</a>
		</div>
		<span class="picright"> <img alt="introduce img"
			src="./img/intro.jpg"> <img alt="introduce img"
			src="./img/intro2.jpg">
		</span>
	</div>
	<div id="recommend">
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<%
			List<Menu> menulist = (List<Menu>) request.getAttribute("menulist");
			for (Menu menu : menulist) {
		%>
		<a href="menuDetail?id=<%=menu.getId()%>"><img
			src=<%=menu.getImg()%> height="30px"></a>
		<%
		}
	%>
		<br>
		<br>
		<br>
	</div>
</body>
</html>