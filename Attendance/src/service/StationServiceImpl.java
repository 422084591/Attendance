package service;

import java.util.List;

import dao.StationDao;
import dao.StationDaoImpl;
import model.Station;

public class StationServiceImpl implements StationService<Station> {
		StationDaoImpl dao=new StationDaoImpl();

		@Override
		public boolean addStaticon(Station t) {// 添加岗位信息
			// TODO Auto-generated method stub
			return dao.addStaticon(t);
		}

		@Override
		public boolean removeStationByStationIds(int[] StationIds) {// 通过岗位id数组批量删除部门信息
			// TODO Auto-generated method stub
			return dao.removeStationByStationIds(StationIds);
		}

		@Override
		public boolean deleteStationByStationId(int stationId) {// 通过岗位编码删除岗位信息
			// TODO Auto-generated method stub
			return dao.deleteStationByStationId(stationId);
		}

		@Override
		public boolean updateStationByStationId(int stationId, Station t) {// 通过岗位编码修改岗位的信息
			// TODO Auto-generated method stub
			return dao.updateStationByStationId(stationId, t);
		}

		@Override
		public List<Station> getAllStations() { // 查询所有岗位的信息
			// TODO Auto-generated method stub
			return dao.getAllStations();
		}

		@Override
		public Station getStationByStationId(int stationId) {// 通过岗位ID来查询
			// TODO Auto-generated method stub
			return dao.getStationByStationId(stationId);
		}

		@Override
		public List<Station> getStationByStationCode(String stationCode) {// 通过岗位编码获得岗位对象
			// TODO Auto-generated method stub
			return dao.getStationByStationCode(stationCode);
		}

		@Override
		public List<Station> getStationByStationName(String stationName) {// 通过岗位姓名查找岗位
			// TODO Auto-generated method stub
			return dao.getStationByStationName(stationName);
		}

		@Override
		public List<Station> getAllByLimit(int limitNumber) {// 每页找出的岗位信息数量
			// TODO Auto-generated method stub
			return dao.getAllByLimit(limitNumber);
		}

		@Override
		public int getMaxPage() {// 当前数据记录一共有几页
			// TODO Auto-generated method stub
			return dao.getMaxPage();
		}
	



}
