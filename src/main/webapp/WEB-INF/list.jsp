<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>java-programming-test</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/list.css">

<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/list.js"></script>
</head>
<body>
	<!-- title区域 -->
	<div>
		<h1>Aptitude Test - Random</h1>
	</div>
	<!-- 标签区域 -->
	<div class="tab_section">
		<table>
			<tr>
				<td class="blueTab" id="aptitude">Aptitude</td>
				<td class="greenTab" id="result">Result & Statistics</td>
			</tr>
		</table>
	</div>
	<!-- 答题区域 -->
	<div class="show_section">
		<div class="answer_section">
			<c:forEach items="${subjects }" var="s">
			<div id="${s.title_id}">
				<table>
					<tbody>
						<th class="content">${s.title_id} . ${s.content }<br/><br/></th>
						<tr><td>&nbsp<input type = "radio" id = "A" name = "options${s.title_id }" value = "${s.option1 }"/>${s.option1 }</td><td class="errorMsg" id="msgA"></td></tr>
				        <tr><td>&nbsp<input type = "radio" id = "B" name = "options${s.title_id }" value = "${s.option2 }"/>${s.option2 }</td><td class="errorMsg" id="msgB"></td></tr>
				        <tr><td>&nbsp<input type = "radio" id = "C" name = "options${s.title_id }" value = "${s.option3 }"/>${s.option3 }</td><td class="errorMsg" id="msgC"></td></tr>
				        <tr><td>&nbsp<input type = "radio" id = "D" name = "options${s.title_id }" value = "${s.option4 }"/>${s.option4 }</td><td class="errorMsg" id="msgD"></td></tr>
				        <c:if test="${s.option5 != null}">
				        	<tr><td>&nbsp<input type = "radio" id = "options${s.title_id }" name = "options${s.title_id }" value = "${s.option5 }"/>${s.option5 }</td><td class="errorMsg" id="msgE"></td></tr>
				        </c:if>
					</tbody>
				</table>
				<!-- 答题结果显示区 -->
				<div class="explain_section">
					<p>
						<span class="an_green" >Answer:</span>
						<span class="an_context"></span>
					</p>
					<p>
						<span class="an_green" >Explanation:</span>
						<span class="ex_context"></span>
					</p>
					<p>
						<span class="an_green">Learn more problems on:</span>
						<span class="an_blue">Permutation and Combination</span>
					</p>
					<p>
						<span class="an_green">Discuss about this problem:</span>
						<span class="an_blue">Discuss in Forum</span>
					</p>
				</div>
			</div>	
			</c:forEach>
			
			<!-- 提交答案区域 -->
			<div class="submit_section">
				<input type="button" value="submit" class="submit"/>
			</div>
		</div>
		
		<!-- note区域 -->
		<div class="note_section">
			<table class="note_table">
				<tr class="note"><td>Note:</td></tr>
				<tr class="info"><td>
					<ul>
						<li >第一行.........</li>
						<li >第二行.........</li>
						<li >第三行.........</li>
					</ul>
				</td></tr>
			</table>
		</div>
		
		<!-- mark区域 -->
		<div class="mark_section">
			<table class="mark_table">
				<tr  class="mark"><td colspan="2" style="text-align:center" id="mark"></td></tr>
				<tr><td class="mark_info">Total number of questions</td><td class="result" id="totalNum"></td></tr>
				<tr><td class="mark_info">Number of answered questions</td><td class="result" id="anNum"></td></tr>
				<tr><td class="mark_info">Number of unanswered questions</td><td class="result" id="unAn"></td></tr>
			</table>
		</div>
		
	</div>
</body>
</html>