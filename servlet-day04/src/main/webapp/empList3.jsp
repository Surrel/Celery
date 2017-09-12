<%@ page pageEncoding="utf-8"  contentType="text/html;charset=utf-8" %>
<%@ page import="entity.*,java.util.*,java.text.* " %>
<html>
	<head>
		<title>员工信息表</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<%@ include file="header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						员工列表
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								姓名
							</td>
							<td>
								年龄
							</td>
							<td>
								工资
							</td>
							<td>
								操作
							</td>
						</tr>
						<% 
							List<Employee> e = (List<Employee>)request.getAttribute("employees");
						    for(int i=0;i<e.size();i++){
						    	Employee e1 = e.get(i);
						    %>
						    	<tr class="row<%= i %2 +1%>">
									<td><%= e1.getId() %></td>
									<td><%= e1.getEname() %></td>
									<td><%= e1.getAge() %></td>
									<td><%= e1.getSalary() %></td>
									<td><a href='del.do?id=<%= e1.getId() %>'>删除</a>&nbsp;
										<a href='load.do?id=<%= e1.getId() %>'>修改</a>
									</td>
								</tr>
						    <%
						    }
						%>
					</table>
				
					<p>
						<input type="button" class="button" value="添加员工" onclick="location='addEmp.jsp'"/>
					</p>
				</div>
			</div>
			<%@ include file="foot.jsp" %>
		</div>
	</body>
</html>
