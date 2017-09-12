<%@ page import = "java.util.*"  contentType= "text/html;charset=utf-8"  
pageEncoding="utf-8" %><!-- 指定字符集解码，保证兼容性 -->
<html>
	<head></head>
	<body style="font-siz:30px;">
		掌中舞罢箫声绝，三十六宫秋夜长
		current time:
		<%
			Date date = new Date();	
			out.println(date);
		%>
		<br/>
		<!-- jsp表达式:将输出的结果放在out.println()里 -->
		current time2:<%= new Date() %>
		<br/>
		<% 
			for(int i=0;i<=100;i++){
				out.println("Hello World<br/>");
			}
		%>
	</body>
</html>