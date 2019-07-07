package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PunchCard;
import util.DBConnection;

public class CheckReportDaoImpl implements CheckReportDao<PunchCard> {
	Connection conn=null;
	DBConnection dbc=new DBConnection();
	PreparedStatement pst=null;
	@Override
	public List<PunchCard> getCheckReportByName(String name) { // 通过考勤表中的名字查找考勤表
		List<PunchCard> list=new ArrayList<PunchCard>();
		String sql=null;
		if(!name.equals("")) {								//判断要查找的名字是否为空
			 sql="select * from checkreport where name=?";	
		}else {
			 sql="select * from checkreport";	
		}
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			if(!name.equals("")) {
				pst.setString(1, name);
			}
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				PunchCard punchCard=new PunchCard();		//储存返回对象
				punchCard.setId(rs.getInt("id"));
				punchCard.setPunchCardMan(rs.getString("name"));
				punchCard.setPunchCardDate(rs.getString("morningBusinessHours"));
				punchCard.setPunchCardDate_end(rs.getString("afternoonBusinessHours"));
				punchCard.setAttendanceSituation(rs.getString("attendanceSituation"));
				list.add(punchCard);		
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
	public List<PunchCard> getAllByLimit(int limitNumber) {// 找出的对应页码的考勤记录
		List<PunchCard> list=new ArrayList<PunchCard>();
		String sql="select * from checkreport limit ?,10";
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,limitNumber*10);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				PunchCard punchCard=new PunchCard();		//储存返回对象
				punchCard.setId(rs.getInt("id"));
				punchCard.setPunchCardMan(rs.getString("name"));
				punchCard.setStaffCode(rs.getString("staffCode"));
				punchCard.setPunchCardDate(rs.getString("morningBusinessHours"));
				punchCard.setPunchCardDate_end(rs.getString("afternoonBusinessHours"));
				punchCard.setAttendanceSituation(rs.getString("attendanceSituation"));
				list.add(punchCard);		
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
	public int getMaxPage(int length) {// 当前数据记录一共有几页
		if(length%10==0) {							//有类似10条等可以被十整除的记录的就显示商的页数-1
			return (length/10)-1;
		}else {
			return (length/10);					//类似12条，24条记录等无法被十整除的数,记录除以十
		}
	}
	@Override
	public List<PunchCard> getAll() {//获取全部对象
		List<PunchCard> list=new ArrayList<PunchCard>();
		String sql="select * from (select * from punchcard union select * from (select Id,repairCradMan punchCardMan,repairCradDate punchCardDate,repairCradReason Remark from repairCrad) s order by punchCardMan,punchCardDate) s left join (select staffCode,name from employees) e on s.punchCardMan=e.name";
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				PunchCard punchCard=new PunchCard();		//储存返回对象
				punchCard.setId(rs.getInt("id"));
				punchCard.setStaffCode(rs.getString("staffCode"));
				punchCard.setPunchCardMan(rs.getString("punchCardMan"));
				punchCard.setPunchCardDate(rs.getString("punchCardDate"));
				punchCard.setRemark(rs.getString("remark"));
				punchCard.setStaffCode(rs.getString("staffCode"));
				list.add(punchCard);		
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
	public void add(PunchCard punchCard) {//添加一条记录
		String sql="insert into checkreport (id,staffCode,name,morningBusinessHours,afternoonBusinessHours,attendanceSituation) values (?,?,?,?,?,?)";
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			
			pst.setInt(1, punchCard.getId());
			pst.setString(2, punchCard.getStaffCode());
			pst.setString(3, punchCard.getPunchCardMan());
			pst.setString(4, punchCard.getPunchCardDate());
			pst.setString(5,punchCard.getPunchCardDate_end());
			pst.setString(6,punchCard.getRemark());
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
	public void remove() {//批量删除
		String sql0="delete from checkreport";
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql0);
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
	public int getMaxPage() {// 当前数据记录一共有几页
		int maxPage = 0;
		String sql="select count(*) as total from checkreport";	
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
	public List<PunchCard> getAllFromCheckReport() {// 从checkReport中取得数据
		List<PunchCard> list=new ArrayList<PunchCard>();
		String sql="select * from checkreport order by morningBusinessHours desc";
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				PunchCard punchCard=new PunchCard();		//储存返回对象
				punchCard.setId(rs.getInt("id"));
				punchCard.setStaffCode("staffCode");
				punchCard.setPunchCardMan(rs.getString("name"));
				punchCard.setPunchCardDate(rs.getString("morningBusinessHours"));
				punchCard.setPunchCardDate_end(rs.getString("afternoonBusinessHours"));
				punchCard.setAttendanceSituation(rs.getString("attendanceSituation"));
				list.add(punchCard);		
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
