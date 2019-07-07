package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Classes;
import model.PunchCard;
import util.DBConnection;

public class ClassesDaoImpl implements ClassesDao<Classes> {
	Connection conn=null;
	DBConnection dbc=new DBConnection();
	PreparedStatement pst=null;
	@Override
	public boolean addClasses(Classes classes) {// 添加打卡单信息
		String sql="insert into classes (code,name,morningBusinessHours,afternoonBusinessHours,remark)  VALUES (?,?,?,?,?)";
		conn=dbc.getConnection();
		boolean temp=false;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,classes.getCode());
			pst.setString(2,classes.getName());
			pst.setString(3,classes.getMorningBusinessHours());
			pst.setString(4,classes.getAfternoonBusinessHours());
			pst.setString(5,classes.getRemark());
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
	public boolean removeClassesByIds(int[] ids) {// 通过打卡单id数组批量删除员工信息
		String sql="delete from classes where id=?";
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
	public boolean deleteClassesById(int id) {// 通过打卡单id删除打卡单信息
		String sql="delete from classes where id=?";
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
	public boolean updateClassesById(int id, Classes classes) { // 通过打卡单的id修改打卡单的信息
		String sql="update  classes set code=?,name=?,morningBusinessHours=?,afternoonBusinessHours=?,remark=? where id=?";
		conn=dbc.getConnection();
		boolean temp=false;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,classes.getCode());
			pst.setString(2,classes.getName());
			pst.setString(3,classes.getMorningBusinessHours());
			pst.setString(4,classes.getAfternoonBusinessHours());
			pst.setString(5,classes.getRemark());
			pst.setInt(6, classes.getId());
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
	public Classes getClassesById(int id) {// 通过打卡单id来找打卡单信息
		String sql="select * from classes where id=?";	
		Classes classes=new Classes();	
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				classes.setId(rs.getInt("id"));
				classes.setCode(rs.getString("code"));
				classes.setName(rs.getString("name"));
				classes.setMorningBusinessHours(rs.getString("morningBusinessHours"));
				classes.setAfternoonBusinessHours(rs.getString("afternoonBusinessHours"));
				classes.setRemark(rs.getString("remark"));
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
		return classes;
	}

	@Override
	public List<Classes> getClassesByName(String name) { // 通过打卡人名字查找打卡单
		List<Classes> list=new ArrayList<Classes>();
		String sql=null;
		if(name.equals("")) {
			 sql="select * from classes";
		}else {
			 sql="select * from classes where name=?";
		}
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			if(!name.equals("")) {
				pst.setString(1,name);
			}
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Classes classes=new Classes();		//储存返回对象
				classes.setId(rs.getInt("id"));
				classes.setCode(rs.getString("code"));
				classes.setName(rs.getString("name"));
				classes.setMorningBusinessHours(rs.getString("morningBusinessHours"));
				classes.setAfternoonBusinessHours(rs.getString("afternoonBusinessHours"));
				classes.setRemark(rs.getString("remark"));
				list.add(classes);		
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
	public List<Classes> getAllByLimit(int limitNumber) {//找出当前页的打卡记录
		List<Classes> list=new ArrayList<Classes>();
		String sql="select * from classes limit ?,10";	
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,limitNumber*10);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Classes classes=new Classes();		//储存返回对象
				classes.setId(rs.getInt("id"));
				classes.setCode(rs.getString("code"));
				classes.setName(rs.getString("name"));
				classes.setMorningBusinessHours(rs.getString("morningBusinessHours"));
				classes.setAfternoonBusinessHours(rs.getString("afternoonBusinessHours"));
				classes.setRemark(rs.getString("remark"));
				list.add(classes);			
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
		String sql="select count(*) as total from classes";	
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
	public List<Classes> getAll() {//获取全部数据
		List<Classes> list=new ArrayList<Classes>();
		String sql="select * from classes";	
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Classes classes=new Classes();		//储存返回对象
				classes.setId(rs.getInt("id"));
				classes.setCode(rs.getString("code"));
				classes.setName(rs.getString("name"));
				classes.setMorningBusinessHours(rs.getString("morningBusinessHours"));
				classes.setAfternoonBusinessHours(rs.getString("afternoonBusinessHours"));
				classes.setRemark(rs.getString("remark"));
				list.add(classes);		
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
