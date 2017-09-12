package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ActionServlet extends HttpServlet{
	public void service(
		HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		PrintWriter out = response.getWriter();
		  EmployeeDAO dao = new EmployeeDAO();
		  Employee emp = new Employee();
		  String uri = request.getRequestURI();
		  String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		  System.out.println(action);
			if("/add".equals(action)){
				try{
				String name = request.getParameter("ename");
				int age = Integer.parseInt(request.getParameter("age"));
				double salary = Double.parseDouble(request.getParameter("salary"));
				emp.setEname(name);
				emp.setAge(age);
				emp.setSalary(salary);
				dao.save(emp);
				response.sendRedirect("list.do");
				}catch(Exception e){
					e.printStackTrace();
					throw new RuntimeException("添加失败");
				}
			}else if("/list".equals(action)){
				try{
					List<Employee> list = dao.findAll();
					//step1.绑定数据到request
					request.setAttribute("employees", list);
					//step2.获得转发器
					RequestDispatcher rd = request.getRequestDispatcher("empList3.jsp");
					//step3.转发
					rd.forward(request, response);
				}catch(Exception e){
					e.printStackTrace();
					throw new RuntimeException("查询失败！");
				} 
			}else if("/del".equals(action)){
				try{
					int id = Integer.parseInt(request.getParameter("id"));
					dao.del(id);	
					response.sendRedirect("list.do");
				}catch(Exception e){
					e.printStackTrace();
					throw new RuntimeException("删除失败!");
				}
				}else if("/load".equals(action)){
					try{
						int id = Integer.parseInt(request.getParameter("id"));
						emp = dao.findByid(id);
						request.setAttribute("load",emp);
						request.getRequestDispatcher("updateEmp.jsp").forward(request, response);
					}catch(Exception e){
						e.printStackTrace();
						throw new RuntimeException("读取失败!");
					}
				}else if("/update".equals(action)){
					try{
						int id = Integer.parseInt(request.getParameter("id"));
						String ename = request.getParameter("ename");
						int age = Integer.parseInt(request.getParameter("age"));
						double salary = Double.parseDouble(request.getParameter("salary"));
						emp.setId(id);
						emp.setEname(ename);
						emp.setAge(age);
						emp.setSalary(salary);
						dao.update(emp);
						response.sendRedirect("list.do");
					}catch(Exception e){
						e.printStackTrace();
						throw new RuntimeException("修改失败");
					}
					
				}
			out.close();
}
}