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
	public void addEmployees(Employees employees) {
		String addToTlogin="insert into tlogin (UserName,PassWord) values (?,?)";
		String addToEmployee="insert into employees (staffCode,name,sex,age,nation,idNumber,salary,phone,emergencyContact,emergencyContactNumber,stationId,individualDescription)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
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
	public void removeEmployeesByEmp_ids(int[] emp_ids) {
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
	public void deleteEmployeesByEmp_id(int emp_id) {
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
	public void updateEmployeesByEmp_id(int emp_id,Employees employees) {
		String sql="update  employees set staffCode=?,name=?,sex=?,age=?,nation=?,idNumber=?,salary=?,phone=?,emergencyContact=?,stationId=?,individualDescription=? where emp_id=?";
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
			pst.setInt(12,emp_id);
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
	public List<Employees> getAllEmployees() {
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
	public Employees getEmployeeByEmp_id(int Emp_id) {
		String sql="select * from (select e.*,s.stationName from employees e left join station s on e.stationId=s.stationId)s where emp_id=?";	
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
				employees.setStationName(rs.getString("stationName"));
				employees.setEmergencyContact(rs.getString("emergencyContact"));
				employees.setEmergencyContactNumber(rs.getString("emergencyContactNumber"));
				employees.setIndividualDescription(rs.getString("individualDescription"));
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
	public List<Employees> getEmployeeByStaffCode(String staffCode) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Employees> getEmployeeByName(String name) {
		List<Employees> list=new ArrayList<Employees>();
		String sql;
		System.out.println(name);
		if(!name.equals("")) {
			sql="select * from (select e.*,s.stationName from employees e left join station s on e.stationId=s.stationId)s where name=?";	
		}else {
			sql="select * from (select e.*,s.stationName from employees e left join station s on e.stationId=s.stationId)s";	
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
				employees.setStationName(rs.getString("stationName"));
				employees.setEmergencyContact(rs.getString("emergencyContact"));
				employees.setEmergencyContactNumber(rs.getString("emergencyContactNumber"));
				employees.setIndividualDescription(rs.getString("individualDescription"));
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
	public List<Employees> getAllByLimit(int limitNumber) {
		List<Employees> list=new ArrayList<Employees>();
		String sql="select e.*,s.stationName from employees e left join station s on e.stationId=s.stationId limit ?,10";
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
				employees.setStationName(rs.getString("stationName"));
				employees.setEmergencyContact(rs.getString("emergencyContact"));
				employees.setEmergencyContactNumber(rs.getString("emergencyContactNumber"));
				employees.setIndividualDescription(rs.getString("individualDescription"));
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
	public int getMaxPage() {
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
