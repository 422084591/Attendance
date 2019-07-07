package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PunchCard;
import model.RepairCard;
import util.DBConnection;

public class RepairCardDaoImpl implements RepairCardDao<RepairCard> {
	Connection conn=null;
	DBConnection dbc=new DBConnection();
	PreparedStatement pst=null;
	@Override
	public boolean addRepairCard(RepairCard repairCard) {// 添加补卡单信息
		String sql="insert into repaircrad (repairCradMan,repairCradDate,repairCradReason)  VALUES (?,?,?)";
		conn=dbc.getConnection();
		boolean temp=false;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, repairCard.getRepairCradMan());
			pst.setString(2,repairCard.getRepairCradDate());
			pst.setString(3,repairCard.getRepairCradReason());
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
	public boolean removeRepairCardByIds(int[] ids) {// 通过补卡单id数组批量删除员工信息
		String sql="delete from repaircrad where id=?";
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
	public boolean deleteRepairCardById(int id) {// 通过补卡单id删除补卡单信息
		String sql="delete from repaircrad where id=?";
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
	public boolean updateRepairCardById(int id, RepairCard repairCard) {// 通过补卡单的id修改补卡单的信息
		String sql="update  repaircrad set repairCradMan=?,repairCradDate=?,repairCradReason=? where id=?";
		conn=dbc.getConnection();
		boolean temp=false;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,repairCard.getRepairCradMan());
			pst.setString(2,repairCard.getRepairCradDate());
			pst.setString(3, repairCard.getRepairCradReason());
			pst.setInt(4,repairCard.getId());
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
	public RepairCard getRepairCardById(int id) {// 通过补卡单id来找补卡单信息
		String sql="select * from repaircrad where id=?";	
		RepairCard repairCard=new RepairCard();//储存返回对象
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				repairCard.setId(rs.getInt("id"));
				repairCard.setRepairCradDate(rs.getString("repairCradDate"));
				repairCard.setRepairCradMan(rs.getString("repairCradMan"));
				repairCard.setRepairCradReason(rs.getString("repairCradReason"));
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
		return repairCard;
	}

	@Override
	public List<RepairCard> getRepairCardByrepairCradMan(String repairCradMan) {// 通过补卡人名字查找补卡单
		List<RepairCard> list=new ArrayList<RepairCard>();
		String sql=null;
		if(repairCradMan.equals("")) {
			 sql="select * from repaircrad";	
		}else {
			sql="select * from repaircrad where repairCradMan=?";
		}

		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			if(!repairCradMan.equals("")) {
				pst.setString(1, repairCradMan);		
			}
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				RepairCard repairCard=new RepairCard();		//储存返回对象
				repairCard.setId(rs.getInt("id"));
				repairCard.setRepairCradDate(rs.getString("repairCradDate"));
				repairCard.setRepairCradMan(rs.getString("repairCradMan"));
				repairCard.setRepairCradReason(rs.getString("repairCradReason"));
				list.add(repairCard);		
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
	public List<RepairCard> getAllByLimit(int limitNumber) {// 找出当前页码的补卡记录
		List<RepairCard> list=new ArrayList<RepairCard>();
		String sql="select * from repaircrad limit ?,10";	
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,limitNumber*10);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				RepairCard repairCard=new RepairCard();
				repairCard.setId(rs.getInt("id"));
				repairCard.setRepairCradDate(rs.getString("repairCradDate"));
				repairCard.setRepairCradMan(rs.getString("repairCradMan"));
				repairCard.setRepairCradReason(rs.getString("repairCradReason"));
				list.add(repairCard);		
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
		String sql="select count(*) as total from repaircrad";	
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
	public List<RepairCard> getAll() { // 获取全部记录
		List<RepairCard> list=new ArrayList<RepairCard>();
		String sql="select * from repaircrad ";	
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				RepairCard repairCard=new RepairCard();
				repairCard.setId(rs.getInt("id"));
				repairCard.setRepairCradDate(rs.getString("repairCradDate"));
				repairCard.setRepairCradMan(rs.getString("repairCradMan"));
				repairCard.setRepairCradReason(rs.getString("repairCradReason"));
				list.add(repairCard);		
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
