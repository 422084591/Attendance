package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PaySalary;
import model.PunchCard;
import util.DBConnection;

public class PaySalaryDaoImpl implements PaySalaryDao<PaySalary> {
	Connection conn=null;
	DBConnection dbc=new DBConnection();
	PreparedStatement pst=null;
	@Override
	public boolean addPaySalary(PaySalary paySalary) {// 添加打卡单信息
		String sql="insert into paysalary (SalariedMan,salary,calculateStartDate,CalculateEndDate,PaidTime)  VALUES (?,?,?,?,?)";
		conn=dbc.getConnection();
		boolean temp=false;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,paySalary.getSalariedMan());
			pst.setString(2, paySalary.getSalary());
			pst.setString(3,paySalary.getCalculateStartDate());
			pst.setString(4,paySalary.getCalculateEndDate());
			pst.setString(5,paySalary.getPaidTime());
			temp= pst.execute();
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
		return temp;
	}

	@Override
	public boolean removePaySalaryByIds(int[] ids) {// 通过打卡单id数组批量删除员工信息
		String sql="delete from paysalary where id=?";
		conn=dbc.getConnection();
		boolean temp=false;
		try {
			pst=conn.prepareStatement(sql);
			for(int id:ids) {
				pst.setInt(1,id);
				temp=pst.execute();
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
		return temp;
	}

	@Override
	public boolean deletePaySalaryById(int id) { // 通过打卡单id删除打卡单信息
		String sql="delete from paysalary where id=?";
		conn=dbc.getConnection();
		boolean temp=false;
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,id);
			temp=pst.execute();
			if(pst.executeUpdate()>0) {
				temp=true;
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
		return temp;
	}

	@Override
	public boolean updatePaySalaryById(int id, PaySalary paySalary) {// 通过打卡单的id修改打卡单的信息
		String sql="update  paysalary set SalariedMan=?,salary=?,calculateStartDate=?,CalculateEndDate=?,PaidTime=? where id=?";
		conn=dbc.getConnection();
		boolean temp=false;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,paySalary.getSalariedMan());
			pst.setString(2, paySalary.getSalary());
			pst.setString(3,paySalary.getCalculateStartDate());
			pst.setString(4,paySalary.getCalculateEndDate());
			pst.setString(5,paySalary.getPaidTime());
			pst.setInt(6,paySalary.getId());
			if(pst.executeUpdate()>0) {
				temp=true;
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
		return temp;
	}

	@Override
	public PaySalary getPaySalaryById(int id) {// 通过打卡单id来找打卡单信息
		String sql="select * from (select * from (select * from paysalary) p left join (select name,staffCode,salary staffSalary,classes from employees) e on p.SalariedMan=e.name)q where id=?";	
		PaySalary paySalary=new PaySalary();       //储存返回对象
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				paySalary.setId(rs.getInt("id"));
				paySalary.setSalary(rs.getString("salary"));
				paySalary.setSalariedMan(rs.getString("SalariedMan"));
				paySalary.setCalculateStartDate(rs.getString("calculateStartDate"));
				paySalary.setCalculateEndDate(rs.getString("CalculateEndDate"));
				paySalary.setPaidTime(rs.getString("PaidTime"));
				paySalary.setStaffCode(rs.getString("staffCode"));
				paySalary.setStaffSalary(rs.getString("staffSalary"));
				paySalary.setClasses(rs.getString("classes"));
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
		return paySalary;
	}

	@Override
	public List<PaySalary> getPaySalaryBySalariedMan(String SalariedMan) {// 通过打卡人名字查找打卡单
		List<PaySalary> list=new ArrayList<PaySalary>();
		String sql=null;
		if(!SalariedMan.equals("")) {
			 sql="select * from (select * from (select * from paysalary) p left join (select name,staffCode,salary staffSalary,classes from employees) e on p.SalariedMan=e.name)q where SalariedMan=?";	
		}else {
			sql="select * from (select * from (select * from paysalary) p left join (select name,staffCode,salary staffSalary,classes from employees) e on p.SalariedMan=e.name)q";	
		}
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			if(!SalariedMan.equals("")) {
				pst.setString(1, SalariedMan);		
			}			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				PaySalary paySalary=new PaySalary();		//储存返回对象
				paySalary.setId(rs.getInt("id"));
				paySalary.setSalary(rs.getString("salary"));
				paySalary.setSalariedMan(rs.getString("SalariedMan"));
				paySalary.setCalculateStartDate(rs.getString("calculateStartDate"));
				paySalary.setCalculateEndDate(rs.getString("CalculateEndDate"));
				paySalary.setPaidTime(rs.getString("PaidTime"));
				paySalary.setStaffCode(rs.getString("staffCode"));
				paySalary.setStaffSalary(rs.getString("staffSalary"));
				paySalary.setClasses(rs.getString("classes"));
				list.add(paySalary);		
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
	public List<PaySalary> getAllByLimit(int limitNumber) {//找出当前页码的打卡记录
		List<PaySalary> list=new ArrayList<PaySalary>();
		String sql="select * from (select * from paysalary) p left join (select name,staffCode,salary staffSalary,classes from employees) e on p.SalariedMan=e.name limit ?,10";	
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,limitNumber*10);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				PaySalary paySalary=new PaySalary();		//储存返回对象
				paySalary.setId(rs.getInt("id"));
				paySalary.setSalary(rs.getString("salary"));
				paySalary.setSalariedMan(rs.getString("SalariedMan"));
				paySalary.setCalculateStartDate(rs.getString("calculateStartDate"));
				paySalary.setCalculateEndDate(rs.getString("CalculateEndDate"));
				paySalary.setPaidTime(rs.getString("PaidTime"));
				paySalary.setStaffCode(rs.getString("staffCode"));
				paySalary.setStaffSalary(rs.getString("staffSalary"));
				paySalary.setClasses(rs.getString("classes"));
				list.add(paySalary);		
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
	public int getMaxPage() { // 当前数据记录一共有几页
		int maxPage = 0;
		String sql="select count(*) as total from paysalary";	
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

	@Override
	public List<PaySalary> getAll() { // 获取所有打卡信息
		List<PaySalary> list=new ArrayList<PaySalary>();
		String sql="select * from (select * from paysalary) p left join (select name,staffCode,salary staffSalary,classes from employees) e on p.SalariedMan=e.name ";	
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				PaySalary paySalary=new PaySalary();		//储存返回对象
				paySalary.setId(rs.getInt("id"));
				paySalary.setSalary(rs.getString("salary"));
				paySalary.setSalariedMan(rs.getString("SalariedMan"));
				paySalary.setCalculateStartDate(rs.getString("calculateStartDate"));
				paySalary.setCalculateEndDate(rs.getString("CalculateEndDate"));
				paySalary.setPaidTime(rs.getString("PaidTime"));
				paySalary.setStaffCode(rs.getString("staffCode"));
				paySalary.setStaffSalary(rs.getString("staffSalary"));
				paySalary.setClasses(rs.getString("classes"));
				list.add(paySalary);		
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

}
