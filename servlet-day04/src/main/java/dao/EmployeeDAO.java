package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;
import util.DBUtil;

public class EmployeeDAO {
	public void save(Employee e){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO t_emp_Celery "
					+ "VALUES(t_emp_Celery_seq.nextval,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getEname());
			ps.setDouble(2, e.getSalary());
			ps.setInt(3, e.getAge());
			ps.executeUpdate();
		} catch (SQLException e1) {
			//step1.记日志(保留现场)
			e1.printStackTrace();
			/*
			 * step2.看异常能否恢复,如果不能够
			 * 恢复(比如，数据库服务暂停等，一般我们
			 * 称之为系统异常),要提示用户稍后重试。
			 * 如果能被恢复，则立即恢复.
			 */
			throw new RuntimeException(e1);
		} finally{
				DBUtil.close(conn);
		}
	}
	public List<Employee> findAll(){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "Select * from t_emp_Celery";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Employee> list = new ArrayList<Employee>();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setEname(rs.getString("ename"));
				emp.setAge(rs.getInt("age"));
				emp.setSalary(rs.getDouble("salary"));
				list.add(emp);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			DBUtil.close(conn);
		}	
	}
	public void del(int id){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from t_emp_Celery "
					+ "where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除失败");
		} finally{
			DBUtil.close(conn);
		}
	}
	public Employee findByid(int id){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select ename,age,salary from t_emp_Celery "
					+ "where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setId(id);
				emp.setEname(rs.getString("ename"));
				emp.setAge(rs.getInt("age"));
				emp.setSalary(rs.getDouble("salary"));
				return emp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找"+id+"失败");
		} finally{
			DBUtil.close(conn);
		}
		return null;
	}
	public void update(Employee e){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update t_emp_Celery "
					+ "set "
					+ "ename=?,"
					+ "salary=?,"
					+ "age=? "
					+ "where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getEname());
			ps.setDouble(2, e.getSalary());
			ps.setInt(3, e.getAge());
			ps.setInt(4, e.getId());
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException("改变错误");
		} finally{
			DBUtil.close(conn);
		}
	}
}
















