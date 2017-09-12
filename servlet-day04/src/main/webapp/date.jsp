<%@ page import = "java.util.*,java.text.*" contentType = "text/html;charset-8"  
pageEncoding = "utf-8" %>
<html>
	<head>
		<title>输出系统时间</title>
		<meta charset="utf-8">
	</head>
	<body>
		今天是:
		<% Date date = new Date(); 
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		%>
		<%= sdf.format(date) %>
	</body>
</html>