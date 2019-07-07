package service;

import java.util.List;

public interface LeaveService<T> {
	public boolean addLeave(T t); // 添加请假单信息

	public boolean removeLeaveByIds(int[] ids); // 通过请假单id数组批量删除员工信息

	public boolean deleteLeaveById(int id); // 通过请假单id删除请假单信息

	public boolean updateLeaveById(int id, T t); // 通过请假单的id修改请假单的信息

	public T getLeaveById(int id); // 通过请假单id来找请假单信息
	
	public List<T> getAll();//获取全部信息

	public List<T> getLeaveByPleaseDummyMan(String pleaseDummyMan); // 通过请假人名字查找请假单

	public List<T> getAllByLimit(int limitNumber); // 每页找出的请假记录数量

	public int getMaxPage(); // 当前数据记录一共有几页
}
