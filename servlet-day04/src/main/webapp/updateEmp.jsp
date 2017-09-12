<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.*,java.text.*,entity.*,dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>修改员工</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<%@ include file="header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						update Emp info:
					</h1>
					<form action="update.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<%
							   Employee emp = (Employee)request.getAttribute("load");
							 
							%>
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
									<%= emp.getId() %>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									name:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="ename" value="<%= emp.getEname() %>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									salary:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" value="<%= emp.getSalary() %> "/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									age:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" value="<%= emp.getAge() %>"/>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="确定" />
							<input type="hidden" name="id" value="<%= emp.getId() %>"/>
						</p>
					</form>
				</div>
			</div>
			<%@ include file="foot.jsp" %>
		</div>
	</body>
</html>
