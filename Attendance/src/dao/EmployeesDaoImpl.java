package dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employees;
import util.DBConnection;

public class EmployeesDaoImpl implements EmployeesDao<Employees>{
	Connection conn=null;
	DBConnection dbc=new DBConnection();
	PreparedStatement pst=null;
	@Override
	public void addEmployees(Employees employees) {// 添加员工信息
		String addToTlogin="insert into tlogin (UserName,PassWord) values (?,?)";
		String addToEmployee="insert into employees (staffCode,name,sex,age,nation,idNumber,salary,phone,emergencyContact,emergencyContactNumber,stationId,individualDescription,classes)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(addToEmployee);
			pst.setString(1,employees.getStaffCode());
			pst.setString(2, employees.getName());
			pst.setString(3, employees.getSex());
			pst.setInt(4, employees.getAge());
			pst.setString(5, employees.getNation());
			pst.setString(6, employees.getIdNumber());
			pst.setString(7, employees.getSalary());
			pst.setString(8, employees.getPhone());
			pst.setString(9, employees.getEmergencyContact());
			pst.setString(10, employees.getEmergencyContactNumber());
			pst.setInt(11, employees.getStationId());
			pst.setString(12, employees.getIndividualDescription());
			pst.setString(13, employees.getClasses());
			 pst.execute();
			pst=conn.prepareStatement(addToTlogin);
			pst.setString(1,employees.getStaffCode());
			pst.setString(2, "123456");
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

	@Override
	public void removeEmployeesByEmp_ids(int[] emp_ids) {// 通过员工id数组批量删除员工信息
		String sql="delete from employees where emp_id=?";
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			for(int id:emp_ids) {
				pst.setInt(1,id);
				pst.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	@Override
	public void deleteEmployeesByEmp_id(int emp_id) {// 通过员工id删除员工信息
		String sql="delete from employees where emp_id=?";
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,emp_id);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	@Override
	public void updateEmployeesByEmp_id(int emp_id,Employees employees) {// 通过员工的id修改员工的信息
		String sql="update  employees set staffCode=?,name=?,sex=?,age=?,nation=?,idNumber=?,salary=?,phone=?,emergencyContact=?,stationId=?,individualDescription=?,classes=? where emp_id=?";
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,employees.getStaffCode());
			pst.setString(2, employees.getName());
			pst.setString(3, employees.getSex());
			pst.setInt(4, employees.getAge());
			pst.setString(5, employees.getNation());
			pst.setString(6, employees.getIdNumber());
			pst.setString(7, employees.getSalary());
			pst.setString(8, employees.getPhone());
			pst.setString(9,employees.getEmergencyContact());
			pst.setInt(10, employees.getStationId());
			pst.setString(11, employees.getIndividualDescription());
			pst.setString(12,employees.getClasses());
			pst.setInt(13,emp_id);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	@Override
	public List<Employees> getAllEmployees() {// 查询所有员工的信息
		List<Employees> list=new ArrayList<Employees>();	//储存数据的列表
		String sql="select * from employees";				
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Employees employees=new Employees();
				employees.setEmp_id(rs.getInt("Emp_id"));
				employees.setStaffCode(rs.getString("staffCode"));
				employees.setName(rs.getString("name"));
				employees.setSex(rs.getString("sex"));
				employees.setAge(rs.getInt("age"));
				employees.setNation(rs.getString("nation"));
				employees.setIdNumber(rs.getString("idNumber"));
				employees.setSalary(rs.getString("salary"));
				employees.setPhone(rs.getString("phone"));
				employees.setStationId(rs.getInt("stationId"));
				employees.setEmergencyContact(rs.getString("emergencyContact"));
				employees.setEmergencyContactNumber(rs.getString("emergencyContactNumber"));
				employees.setIndividualDescription(rs.getString("individualDescription"));
				employees.setClasses(rs.getString("classes"));
				list.add(employees);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}
	@Override
	public Employees getEmployeeByEmp_id(int Emp_id) {// 通过员工id来找员工信息,其中包括部门id对应的部门编码和名称
		String sql="select * from (select e.*,s.stationName from employees e left join station s on e.stationId=s.stationId)s where emp_id=?  order by emp_id";	
		Employees employees=new Employees();				//储存返回对象
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,Emp_id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				employees.setEmp_id(rs.getInt("Emp_id"));
				employees.setStaffCode(rs.getString("staffCode"));
				employees.setName(rs.getString("name"));
				employees.setSex(rs.getString("sex"));
				employees.setAge(rs.getInt("age"));
				employees.setNation(rs.getString("nation"));
				employees.setIdNumber(rs.getString("idNumber"));
				employees.setSalary(rs.getString("salary"));
				employees.setPhone(rs.getString("phone"));
				employees.setStationId(rs.getInt("stationId"));
				employees.setEmergencyContact(rs.getString("emergencyContact"));
				employees.setEmergencyContactNumber(rs.getString("emergencyContactNumber"));
				employees.setIndividualDescription(rs.getString("individualDescription"));
				employees.setClasses(rs.getString("classes"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return employees;
	}
	@Override
	public List<Employees> getEmployeeByName(String name) {// 通过员工姓名查找员工
		List<Employees> list=new ArrayList<Employees>();
		String sql;
		if(!name.equals("")) {
			sql="select * from (select e.*,s.stationName from employees e left join station s on e.stationId=s.stationId)s where name=? order by emp_id ";	
		}else {
			sql="select * from (select e.*,s.stationName from employees e left join station s on e.stationId=s.stationId)s order by emp_id";	
		}
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			if(!name.equals("")) {
				pst.setString(1, name);
			}
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Employees employees=new Employees();
				employees.setEmp_id(rs.getInt("Emp_id"));
				employees.setStaffCode(rs.getString("staffCode"));
				employees.setName(rs.getString("name"));
				employees.setSex(rs.getString("sex"));
				employees.setAge(rs.getInt("age"));
				employees.setNation(rs.getString("nation"));
				employees.setIdNumber(rs.getString("idNumber"));
				employees.setSalary(rs.getString("salary"));
				employees.setPhone(rs.getString("phone"));
				employees.setStationId(rs.getInt("stationId"));
				employees.setEmergencyContact(rs.getString("emergencyContact"));
				employees.setEmergencyContactNumber(rs.getString("emergencyContactNumber"));
				employees.setIndividualDescription(rs.getString("individualDescription"));
				employees.setClasses(rs.getString("classes"));
				list.add(employees);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}
	
	

	@Override
	public List<Employees> getAllByLimit(int limitNumber) {// 每页找出的员工信息数量
		List<Employees> list=new ArrayList<Employees>();
		String sql="select e.*,s.stationName from employees e left join station s on e.stationId=s.stationId order by emp_id limit ?,10";
		Employees employees=null;				//储存返回对象
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,limitNumber*10);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				employees=new Employees();
				employees.setEmp_id(rs.getInt("Emp_id"));
				employees.setStaffCode(rs.getString("staffCode"));
				employees.setName(rs.getString("name"));
				employees.setSex(rs.getString("sex"));
				employees.setAge(rs.getInt("age"));
				employees.setNation(rs.getString("nation"));
				employees.setIdNumber(rs.getString("idNumber"));
				employees.setSalary(rs.getString("salary"));
				employees.setPhone(rs.getString("phone"));
				employees.setStationId(rs.getInt("stationId"));
				employees.setEmergencyContact(rs.getString("emergencyContact"));
				employees.setEmergencyContactNumber(rs.getString("emergencyContactNumber"));
				employees.setIndividualDescription(rs.getString("individualDescription"));
				employees.setClasses(rs.getString("classes"));
				list.add(employees);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}

	@Override
	public int getMaxPage() {// 当前数据记录一共有几页
		int maxPage = 0;
		String sql="select count(*) as total from employees";	
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				maxPage=rs.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(maxPage%10==0) {							//有类似10条等可以被十整除的记录的就显示商的页数-1
			return (maxPage/10)-1;
		}else {
			return (maxPage/10);					//类似12条，24条记录等无法被十整除的数,记录除以十
		}
	}




}
