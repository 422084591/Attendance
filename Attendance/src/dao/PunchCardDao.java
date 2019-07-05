package dao;

import java.util.List;

public interface PunchCardDao<T> {
	public boolean addPunchCard(T t); // 添加打卡单信息

	public boolean removePunchCardByIds(int[] ids); // 通过打卡单id数组批量删除员工信息

	public boolean deletePunchCardById(int id); // 通过打卡单id删除打卡单信息

	public boolean updatePunchCardById(int id, T t); // 通过打卡单的id修改打卡单的信息

	public T getPunchCardById(int id); // 通过打卡单id来找打卡单信息

	public List<T> getPunchCardByPunchCardMan(String punchCardMan); // 通过打卡人名字查找打卡单

	public List<T> getAllByLimit(int limitNumber); // 每页找出的打卡记录数量

	public int getMaxPage(); // 当前数据记录一共有几页

	public List<T> getAll(); // 获取全部记录
}
