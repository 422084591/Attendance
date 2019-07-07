package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Department;
import util.DBConnection;

public class DepartmentDaoImpl implements DepartmentDao<Department> {
	Connection conn = null;
	DBConnection dbc = new DBConnection();
	PreparedStatement pst = null;

	@Override
	public boolean addDepartment(Department department) {// 增加部门信息
		String sql = "insert into department (departmentCode,departmentName,departmentHead,departmentResponsibility,superiorDepartmentId) values(?,?,?,?,?)";
		conn = dbc.getConnection();
		boolean temp = false;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, department.getDepartmentCode());
			pst.setString(2, department.getDepartmentName());
			pst.setString(3, department.getDepartmentHead());
			pst.setString(4, department.getDepartmentResponsibility());
			pst.setInt(5, department.getSuperiorDepartmentId());
			temp = pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return temp;
	}

	@Override
	public boolean removeDepartmentByDepartmentIds(int[] departmentIds) {// 批量删除部门信息
		String sql = "delete from department where departmentID=?";
		conn = dbc.getConnection();
		boolean temp = false;
		try {
			pst = conn.prepareStatement(sql);
			for (int id : departmentIds) {
				pst.setInt(1, id);
				temp = pst.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;

	}

	@Override
	public boolean deletaDepartmentByDempartmentId(int departmentId) {// 通过部门ID删除部门信息
		String sql = "delete from department where departmentID=?";
		conn = dbc.getConnection();
		boolean temp = false;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, departmentId);
			temp = pst.execute();
			if (pst.executeUpdate() > 0) {
				temp = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return temp;
	}

	@Override
	public boolean updateDepartmentByDepartmentId(int departmentId, Department department) {// 通过部门ID修改部门信息
		String sql = "update  department set departmentCode=?,departmentName=?,departmentHead=?,departmentResponsibility=?,superiorDepartmentId=? where departmentID=?";
		conn = dbc.getConnection();
		boolean temp = false;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, department.getDepartmentCode());
			pst.setString(2, department.getDepartmentName());
			pst.setString(3, department.getDepartmentHead());
			pst.setString(4, department.getDepartmentResponsibility());
			pst.setInt(5, department.getSuperiorDepartmentId());
			pst.setInt(6, departmentId);
			if (pst.executeUpdate() > 0) {
				temp = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return temp;
	}

	@Override
	public List<Department> getAllDepartmentInfo() {// 获得所有的部门信息

		List<Department> list = new ArrayList<Department>(); // 储存数据的链表
		String sql = "select * from department";
		conn = dbc.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Department department = new Department();
				department.setDepartmentID(rs.getInt("departmentID"));
				department.setDepartmentCode(rs.getString("departmentCode"));
				department.setDepartmentName(rs.getString("departmentName"));
				department.setDepartmentHead(rs.getString("departmentHead"));
				department.setDepartmentResponsibility(rs.getString("departmentResponsibility"));
				department.setSuperiorDepartmentId(rs.getInt("superiorDepartmentId"));
				list.add(department);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	public Department getDepartmentByDepartmentID(int departmentID) {// 通过部门id来找部门信息
		String sql = "select * from department where departmentID=?";
		Department department = new Department(); // 储存返回对象
		conn = dbc.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, departmentID);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				department.setDepartmentID(rs.getInt("departmentID"));
				department.setDepartmentCode(rs.getString("departmentCode"));
				department.setDepartmentName(rs.getString("departmentName"));
				department.setDepartmentHead(rs.getString("departmentHead"));
				department.setDepartmentResponsibility(rs.getString("departmentResponsibility"));
				department.setSuperiorDepartmentId(rs.getInt("superiorDepartmentId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return department;
	}

	@Override
	public List<Department> getDepartmentByDepartmentCode(String departmentCode) {// 通过部门编码获得员工对象
		List<Department> list = new ArrayList<Department>(); // 储存数据的链表
		String sql = "select * from department where departmentCode=?";
		conn = dbc.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, departmentCode);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Department department = new Department();
				department.setDepartmentID(rs.getInt("departmentID"));
				department.setDepartmentCode(rs.getString("departmentCode"));
				department.setDepartmentName(rs.getString("departmentName"));
				department.setDepartmentHead(rs.getString("departmentHead"));
				department.setDepartmentResponsibility(rs.getString("departmentResponsibility"));
				department.setSuperiorDepartmentId(rs.getInt("superiorDepartmentId"));
				list.add(department);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	public List<Department> getDepartmentByDepartmentName(String dapartmentName) {// 通过部门名称查找员工
		List<Department> list = new ArrayList<Department>(); // 储存数据的链表
		String sql=null;
		if(dapartmentName.equals("")) {
			sql = "select * from (select s.*,d.departmentName superiorDepartmentName from department d,department s where d.departmentID=s.superiorDepartmentId)s";
		}else {
			sql = "select * from (select s.*,d.departmentName superiorDepartmentName from department d,department s where d.departmentID=s.superiorDepartmentId)s where departmentName=?";
		}
		conn = dbc.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			if(!dapartmentName.equals("")) {				
				pst.setString(1, dapartmentName);
			}
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Department department = new Department();
				department.setDepartmentID(rs.getInt("departmentID"));
				department.setDepartmentCode(rs.getString("departmentCode"));
				department.setDepartmentName(rs.getString("departmentName"));
				department.setDepartmentHead(rs.getString("departmentHead"));
				department.setDepartmentResponsibility(rs.getString("departmentResponsibility"));
				department.setSuperiorDepartmentId(rs.getInt("superiorDepartmentId"));
				department.setSuperiorDepartmentName(rs.getString("superiorDepartmentName"));
				list.add(department);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	public List<Department> getAllByLimit(int limitNumber) {// 每页找出的部门信息数量
		List<Department> list = new ArrayList<Department>();
		String sql = " select s.*,d.departmentName superiorDepartmentName from department d,department s where d.departmentID=s.superiorDepartmentId limit ?,10";
		conn = dbc.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, limitNumber*10);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Department department = new Department(); // 储存返回对象
				department.setDepartmentID(rs.getInt("departmentID"));
				department.setDepartmentCode(rs.getString("departmentCode"));
				department.setDepartmentName(rs.getString("departmentName"));
				department.setDepartmentHead(rs.getString("departmentHead"));
				department.setDepartmentResponsibility(rs.getString("departmentResponsibility"));
				department.setSuperiorDepartmentId(rs.getInt("superiorDepartmentId"));
				department.setSuperiorDepartmentName(rs.getString("superiorDepartmentName"));
				list.add(department);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
			String sql="select count(*) as total from department";	
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

