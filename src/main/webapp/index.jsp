<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/index.css">

<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/index.js"></script>
</head>
<body>
	<div class="main">
		<h3>Login</h3>
		<form action="<%=request.getContextPath() %>/online-test/checkLogin.html" method="post">
		<input type="text" placeholder="Input Username" value="${username }" name="username" class="username"/>
		<input type="password" placeholder="Input Password" value="${password }" name="password" class="pwd"/>
		<input type="submit" value="Login" id="login"/><br/>
		<input type="button" value="Visitor Login" id="vlogin"/><br/>
		<span id="errorMsg">${message }</span>
		</form>
		<br/>
		
	</div>
</body>
</html>