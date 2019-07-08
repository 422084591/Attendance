package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Leave;
import model.PunchCard;
import util.DBConnection;

public class LeaveDaoImpl implements LeaveDao<Leave>{
	Connection conn=null;
	DBConnection dbc=new DBConnection();
	PreparedStatement pst=null;
	@Override
	public boolean addLeave(Leave leave) {// 添加请假单信息
		String sql="insert into leaves (pleaseDummyMan,startTime,endTime,leaveReason)  VALUES (?,?,?,?)";		//把表名从leave改为leaves防治与leave关键字重复
		conn=dbc.getConnection();
		boolean temp=false;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,leave.getPleaseDummyMan());
			pst.setString(2,leave.getStartTime());
			pst.setString(3,leave.getEndTime());
			pst.setString(4, leave.getLeaveReason()); 
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
	public boolean removeLeaveByIds(int[] ids) {// 通过请假单id数组批量删除员工信息
		String sql="delete from leaves where id=?";
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
	public boolean deleteLeaveById(int id) {// 通过请假单id删除请假单信息
		String sql="delete from leaves where id=?";
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
	public boolean updateLeaveById(int id, Leave leave) {// 通过请假单的id修改请假单的信息
		String sql="update  leaves set pleaseDummyMan=?,startTime=?,endTime=?,leaveReason=? where id=?";
		conn=dbc.getConnection();
		boolean temp=false;
		try {
			pst=conn.prepareStatement(sql);
				pst.setString(1, leave.getPleaseDummyMan());
				pst.setString(2,leave.getStartTime());
				pst.setString(3,leave.getEndTime());
				pst.setString(4,leave.getLeaveReason());
				pst.setInt(5, leave.getId());
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
	public Leave getLeaveById(int id) {// 通过请假单id来找请假单信息
		String sql="select * from leaves where id=?";	
		Leave leave=new Leave();//储存返回对象
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,id);
			ResultSet rs=pst.executeQuery();
			pst.setInt(1, id);
			while(rs.next()) {
					leave.setId(rs.getInt("id"));
					leave.setPleaseDummyMan(rs.getString("pleaseDummyMan"));
					leave.setStartTime(rs.getString("startTime"));
					leave.setEndTime(rs.getString("endTime"));
					leave.setLeaveReason(rs.getString("leaveReason"));
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
		return leave;
	}

	@Override
	public List<Leave> getLeaveByPleaseDummyMan(String pleaseDummyMan) {// 通过请假人名字查找请假单
		String sql="select * from leaves where pleaseDummyMan=?";	
		List<Leave> list=new ArrayList<Leave>();
		Leave leave=new Leave();//储存返回对象
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, pleaseDummyMan);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				leave.setId(rs.getInt("id"));
				leave.setPleaseDummyMan(rs.getString("pleaseDummyMan"));
				leave.setStartTime(rs.getString("startTime"));
				leave.setEndTime(rs.getString("endTime"));
				leave.setLeaveReason(rs.getString("leaveReason"));
				list.add(leave);
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
	public List<Leave> getAllByLimit(int limitNumber) {// 每页找出的请假记录数量
		List<Leave> list=new ArrayList<Leave>();
		String sql="select * from leaves limit ?,10";	
		conn=dbc.getConnection();	
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,limitNumber*10);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Leave leave=new Leave();//储存返回对象
				leave.setId(rs.getInt("Id"));
				leave.setPleaseDummyMan(rs.getString("pleaseDummyMan"));
				leave.setStartTime(rs.getString("startTime"));
				leave.setEndTime(rs.getString("endTime"));
				leave.setLeaveReason(rs.getString("leaveReason"));
				list.add(leave);
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
		String sql="select count(*) as total from leaves";	
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
	public List<Leave> getAll() {//获取全部信息
		List<Leave> list=new ArrayList<Leave>();
		String sql="select * from leaves";	
		conn=dbc.getConnection();	
		try {
			pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Leave leave=new Leave();//储存返回对象
				leave.setId(rs.getInt("Id"));
				leave.setPleaseDummyMan(rs.getString("pleaseDummyMan"));
				leave.setStartTime(rs.getString("startTime"));
				leave.setEndTime(rs.getString("endTime"));
				leave.setLeaveReason(rs.getString("leaveReason"));
				list.add(leave);
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
