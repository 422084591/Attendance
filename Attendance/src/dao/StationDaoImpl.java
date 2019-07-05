package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Department;
import model.Employees;
import model.Station;
import util.DBConnection;

public class StationDaoImpl implements StationDao<Station>{
	Connection conn=null;
	DBConnection dbc=new DBConnection();
	PreparedStatement pst=null;
	@Override
	public boolean addStaticon(Station station) {
		String sql="insert into station (stationCode,stationName,department,immediateSuperior,stationCategory,stationDescription)  VALUES (?,?,?,?,?,?)";
		conn=dbc.getConnection();
		boolean temp=false;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,station.getStationCode());
			pst.setString(2, station.getStationName());
			pst.setString(3,station.getDepartment());
			pst.setString(4, station.getImmediateSuperior());
			pst.setString(5, station.getStationCategory());
			pst.setString(6, station.getStationDescription());
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
	public boolean removeStationByStationIds(int[] StationIds) {
		String sql="delete from station where stationId=?";
		conn=dbc.getConnection();
		boolean temp=false;
		try {
			pst=conn.prepareStatement(sql);
			for(int id:StationIds) {
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
	public boolean deleteStationByStationId(int stationId) {
		String sql="delete from station where stationId=?";
		conn=dbc.getConnection();
		boolean temp=false;
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,stationId);
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
	public boolean updateStationByStationId(int stationId,Station station) {
		String sql="update  station set stationCode=?,stationName=?,department=?,immediateSuperior=?,stationCategory=?,stationDescription=? where stationId=?";
		conn=dbc.getConnection();
		boolean temp=false;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,station.getStationCode());
			pst.setString(2,station.getStationName() );
			pst.setString(3, station.getDepartment());
			pst.setString(4, station.getImmediateSuperior());
			pst.setString(5, station.getStationCategory());
			pst.setString(6,station.getStationDescription());
			pst.setInt(7, station.getStationId());
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
			}}
			return temp;
	}
	@Override
	public List<Station> getAllStations() {
		List<Station> list=new ArrayList<Station>();	//储存数据的链表
		String sql="select * from station";				
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
					Station station=new Station();
					station.setStationId(rs.getInt("stationId"));
					station.setStationCode(rs.getString("stationCode"));
					station.setStationName(rs.getString("stationName"));
					station.setDepartment(rs.getString("department"));
					station.setImmediateSuperior(rs.getString("immediateSuperior"));
					station.setStationCategory(rs.getString("stationCategory"));
					station.setStationDescription(rs.getString("stationDescription"));
					list.add(station);
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
	public Station getStationByStationId(int stationId) {
		String sql="select * from station where stationId=?";	
		Station station=new Station();										//储存返回对象
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,stationId);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				station.setStationId(rs.getInt("stationId"));
				station.setStationCode(rs.getString("stationCode"));
				station.setStationName(rs.getString("stationName"));
				station.setDepartment(rs.getString("department"));
				station.setImmediateSuperior(rs.getString("immediateSuperior"));
				station.setStationCategory(rs.getString("stationCategory"));
				station.setStationDescription(rs.getString("stationCategory"));
				station.setStationDescription(rs.getString("stationDescription"));
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
		return station;
	}
	@Override
	public List<Station> getStationByStationCode(String stationCode) {
		List<Station> list=new ArrayList<Station>();	//储存数据的链表
		String sql="select * from station where stationCode=?";				
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,stationCode);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
					Station station=new Station();
					station.setStationId(rs.getInt("stationId"));
					station.setStationCode(rs.getString("stationCode"));
					station.setStationName(rs.getString("stationName"));
					station.setDepartment(rs.getString("department"));
					station.setImmediateSuperior(rs.getString("immediateSuperior"));
					station.setStationCategory(rs.getString("stationCategory"));
					station.setImmediateSuperiorCode(rs.getString("immediateSuperiorCode"));
					station.setStationDescription(rs.getString("stationDescription"));
					list.add(station);
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
	public List<Station> getStationByStationName(String stationName) {
		List<Station> list=new ArrayList<Station>();	//储存数据的链表
		String sql;
		if(stationName.equals("")){
			 sql="select * from (select s.*,e.stationCode immediateSuperiorCode  from station s,station e where s.immediateSuperior=e.stationId) s";				
		}else {
			 sql="select * from (select s.*,e.stationCode immediateSuperiorCode  from station s,station e where s.immediateSuperior=e.stationId) s where stationName=?";				
		}
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			if(!stationName.equals("")) {
				
				pst.setString(1,stationName);
			}
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
					Station station=new Station();
					station.setStationId(rs.getInt("stationId"));
					station.setStationCode(rs.getString("stationCode"));
					station.setStationName(rs.getString("stationName"));
					station.setDepartment(rs.getString("department"));
					station.setImmediateSuperior(rs.getString("immediateSuperior"));
					station.setStationCategory(rs.getString("stationCategory"));
					station.setImmediateSuperiorCode(rs.getString("immediateSuperiorCode"));
					station.setStationDescription(rs.getString("stationDescription"));
					list.add(station);
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
	public List<Station> getAllByLimit(int limitNumber) {
		List<Station> list=new ArrayList<Station>();
		String sql=" select s.*,e.stationCode immediateSuperiorCode  from station s,station e where s.immediateSuperior=e.stationId limit ?,10";	
		conn=dbc.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,limitNumber*10);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Station station=new Station();			//储存返回对象
				station.setStationId(rs.getInt("stationId"));
				station.setStationCode(rs.getString("stationCode"));
				station.setStationName(rs.getString("stationName"));
				station.setDepartment(rs.getString("department"));
				station.setImmediateSuperior(rs.getString("immediateSuperior"));
				station.setStationCategory(rs.getString("stationCategory"));
				station.setImmediateSuperiorCode(rs.getString("immediateSuperiorCode"));
				station.setStationDescription(rs.getString("stationDescription"));
				list.add(station);		
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
		String sql="select count(*) as total from station";	
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
