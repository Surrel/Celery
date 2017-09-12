<%@ page pageEncoding="utf-8"  contentType="text/html;charset=utf-8" %>
<%@ page import="entity.*,dao.*,java.util.*,java.text.* " %>
<html>
	<head>
		<title>员工信息表</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							<% Date date = new Date();
							   SimpleDateFormat sdf = new SimpleDateFormat("yy年MM月dd hh时mm分ss秒");
							%>
							<%= sdf.format(date) %>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
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
							EmployeeDAO dao = new EmployeeDAO();
							List<Employee> e = dao.findAll();
						    for(int i=0;i<e.size();i++){
						    	Employee e1 = e.get(i);
						    %>
						    	<tr class="row<%= i %2 +1%>">
									<td><%= e1.getId() %></td>
									<td><%= e1.getEname() %></td>
									<td><%= e1.getAge() %></td>
									<td><%= e1.getSalary() %></td>
									<td><a href="emplist.jsp">删除</a>&nbsp;
										<a href="updateEmp.jsp">修改</a>
									</td>
								</tr>
						    <%
						    }
						%>
					</table>
				
					<p>
						<input type="button" class="button" value="添加员工" onclick="location='addEmp.html'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
