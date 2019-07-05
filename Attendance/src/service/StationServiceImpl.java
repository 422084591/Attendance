package service;

import java.util.List;

import dao.StationDao;
import dao.StationDaoImpl;
import model.Station;

public class StationServiceImpl implements StationService<Station> {
		StationDaoImpl dao=new StationDaoImpl();

		@Override
		public boolean addStaticon(Station t) {
			// TODO Auto-generated method stub
			return dao.addStaticon(t);
		}

		@Override
		public boolean removeStationByStationIds(int[] StationIds) {
			// TODO Auto-generated method stub
			return dao.removeStationByStationIds(StationIds);
		}

		@Override
		public boolean deleteStationByStationId(int stationId) {
			// TODO Auto-generated method stub
			return dao.deleteStationByStationId(stationId);
		}

		@Override
		public boolean updateStationByStationId(int stationId, Station t) {
			// TODO Auto-generated method stub
			return dao.updateStationByStationId(stationId, t);
		}

		@Override
		public List<Station> getAllStations() {
			// TODO Auto-generated method stub
			return dao.getAllStations();
		}

		@Override
		public Station getStationByStationId(int stationId) {
			// TODO Auto-generated method stub
			return dao.getStationByStationId(stationId);
		}

		@Override
		public List<Station> getStationByStationCode(String stationCode) {
			// TODO Auto-generated method stub
			return dao.getStationByStationCode(stationCode);
		}

		@Override
		public List<Station> getStationByStationName(String stationName) {
			// TODO Auto-generated method stub
			return dao.getStationByStationName(stationName);
		}

		@Override
		public List<Station> getAllByLimit(int limitNumber) {
			// TODO Auto-generated method stub
			return dao.getAllByLimit(limitNumber);
		}

		@Override
		public int getMaxPage() {
			// TODO Auto-generated method stub
			return dao.getMaxPage();
		}
	



}
