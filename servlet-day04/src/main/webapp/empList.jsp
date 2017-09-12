<%@ page pageEncoding="utf-8"  contentType="text/html;charset=utf-8" %>
<%@ page import="entity.*,dao.*,java.util.* " %>
<html>
	<head>
		<style>
			.row1{
				background-color:#fff8dc;
			}
			.row2{
				background-color:#f0f0f0;		
			}
		</style>
	</head>
	<body	style="font-size:30px;">
		<table width="60%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>ID</td><td>姓名</td>
				<td>工资</td><td>年龄</td>
			</tr>	
			<%
				EmployeeDAO dao = new EmployeeDAO();
				List<Employee> employees = dao.findAll();
				for(int i =0;i<employees.size();i++){
					Employee e = employees.get(i);
					%>
					<tr class="row<%=i % 2 +1%>">
						<td><%=e.getId() %></td>
						<td><%=e.getEname() %></td>
						<td><%=e.getAge() %></td>
						<td><%=e.getSalary() %></td>
					</tr>
					<% 
				}
			%>
		</table>
	</body>
	
</html>