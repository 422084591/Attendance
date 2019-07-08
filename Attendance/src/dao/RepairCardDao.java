package dao;

import java.util.List;

public interface RepairCardDao<T> {
	public boolean addRepairCard(T t); // 添加补卡单信息

	public boolean removeRepairCardByIds(int[] ids); // 通过补卡单id数组批量删除员工信息

	public boolean deleteRepairCardById(int id); // 通过补卡单id删除补卡单信息

	public boolean updateRepairCardById(int id, T t); // 通过补卡单的id修改补卡单的信息

	public T getRepairCardById(int id); // 通过补卡单id来找补卡单信息

	public List<T> getRepairCardByrepairCradMan(String repairCradMan); // 通过补卡人名字查找补卡单

	public List<T> getAllByLimit(int limitNumber); // 找出当前页码的补卡记录

	public int getMaxPage(); // 当前数据记录一共有几页

	public List<T> getAll(); // 获取全部记录
}
