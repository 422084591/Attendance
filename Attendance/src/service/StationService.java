package service;

import java.util.List;

import model.Station;

public interface StationService<T> {
	public boolean addStaticon(T t); // 添加岗位信息

	public boolean removeStationByStationIds(int[] StationIds); // 通过岗位id数组批量删除部门信息

	public boolean deleteStationByStationId(int stationId); // 通过岗位编码删除岗位信息

	public boolean updateStationByStationId(int stationId, T t); // 通过岗位编码修改岗位的信息

	public List<T> getAllStations(); // 查询所有岗位的信息
	
	public T getStationByStationId(int stationId); // 通过岗位ID来查询

	public List<T> getStationByStationCode(String stationCode); // 通过岗位编码获得岗位对象

	public List<T> getStationByStationName(String stationName); // 通过岗位姓名查找岗位

	public List<T> getAllByLimit(int limitNumber); // 每页找出的岗位信息数量

	public int getMaxPage(); // 当前数据记录一共有几页
}
