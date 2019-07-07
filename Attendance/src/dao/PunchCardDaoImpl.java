package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;
import util.DBConnection;
public class PunchCardDaoImpl implements PunchCardDao<PunchCard> {
	Connection conn=null;
	DBConnection dbc=new DBConnection();
	PreparedStatement pst=null;
	@Override
	public boolean addPunchCard(PunchCard punchCard) {// 添加打卡单信息
		String sql="insert into punchcard (punchCardMan,punchCardDate,Remark)  VALUES (?,?,?)";
		conn=dbc.getConnection();
		boolean temp=false;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,punchCard.getPunchCardMan());
			pst.setString(2, punchCard.getPunchCardDate());
			pst.setString(3,punchCard.getRemark());
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
	public boolean removePunchCardByIds(int[] ids) {// 通过打卡单id数组批量删除员工信息
		String sql="delete from punchcard where id=?";
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
	public boolean deletePunchCardById(int id) {// 通过打卡单id删除打卡单信息
		String sql="delete from punchcard where id=?";
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
	public boolean updatePunchCardById(int id, PunchCard punchCard) {// 通过打卡单的id修改打卡单的信息
		String sql="update  punchcard set punchCardMan=?,punchCardDate=?,Remark=? where id=?";
		conn=dbc.getConnection();
		boolean temp=false;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,punchCard.getPunchCardMan());
			pst.setString(2, punchCard.getPunchCardDate());
			pst.setString(3, punchCard.getRemark());
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
	public PunchCard getPunchCardById(int id) {// 通过打卡单id来找打卡单信息
		String sql="select * from punchCard where id=?";	
		PunchCard punchCard=new PunchCard();//储存返回对象
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				punchCard.setId(rs.getInt("id"));
				punchCard.setPunchCardMan(rs.getString("punchCardMan"));
				punchCard.setPunchCardDate(rs.getString("punchCardDate"));
				punchCard.setRemark(rs.getString("Remark"));
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
		return punchCard;
	}

	@Override
	public List<PunchCard> getPunchCardByPunchCardMan(String punchCardMan) {// 通过打卡人名字查找打卡单
		List<PunchCard> list=new ArrayList<PunchCard>();
		String sql=null;
		if(punchCardMan.equals("")) {
			 sql="select * from punchcard";	
		}else {
			 sql="select * from punchcard where punchCardMan=?";		
		}
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			if(!punchCardMan.equals("")) {
				pst.setString(1, punchCardMan);
			}
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				PunchCard punchCard=new PunchCard();		//储存返回对象
				punchCard.setId(rs.getInt("id"));
				punchCard.setPunchCardMan(rs.getString("punchCardMan"));
				punchCard.setPunchCardDate(rs.getString("punchCardDate"));
				punchCard.setRemark(rs.getString("remark"));
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
	public List<PunchCard> getAllByLimit(int limitNumber) {// 找出当前页的打卡记录
		List<PunchCard> list=new ArrayList<PunchCard>();
		String sql="select * from punchcard limit ?,10";	
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,limitNumber*10);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				PunchCard punchCard=new PunchCard();		//储存返回对象
				punchCard.setId(rs.getInt("id"));
				punchCard.setPunchCardMan(rs.getString("punchCardMan"));
				punchCard.setPunchCardDate(rs.getString("punchCardDate"));
				punchCard.setRemark(rs.getString("remark"));
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
	public int getMaxPage() {// 当前数据记录一共有几页
		int maxPage = 0;
		String sql="select count(*) as total from punchCard";	
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
	public List<PunchCard> getAll() {// 获取全部记录
		List<PunchCard> list=new ArrayList<PunchCard>();
		String sql="select * from punchcard";	
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				PunchCard punchCard=new PunchCard();		//储存返回对象
				punchCard.setId(rs.getInt("id"));
				punchCard.setPunchCardMan(rs.getString("punchCardMan"));
				punchCard.setPunchCardDate(rs.getString("punchCardDate"));
				punchCard.setRemark(rs.getString("remark"));
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
