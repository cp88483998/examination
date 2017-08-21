<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/error.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/error.js"></script>
</head>
<body>
	<div class="img">
		<img alt="error" src="<%=request.getContextPath() %>/images/error.gif">
	</div>	
	<div class="main">
		<h2 id="error">
			遇到错误，<span id="seconds">5</span>秒后将自动跳转，或点击立即跳转
			<a class="back" href="">返回</a>
		</h2>
	</div>
</body>
</html>