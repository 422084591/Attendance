package service;

import java.util.List;

import model.PunchCard;

public interface CheckReportService<T> {
	public List<T> getCheckReportByName(String name); // 通过考勤表中的名字查找考勤表

	public List<T> getAllByLimit(int limitNumber); // 每页找出的考勤记录数量

	public int getMaxPage(int length); // 当前数据记录一共有几页

	public List<T> getAll();//获取全部对象

	public void add(PunchCard punchCard);//添加一条记录

	public void remove();//批量删除

	public int getMaxPage(); // 当前数据记录一共有几页

	public List<T> getAllFromCheckReport(); // 从checkReport中取得数据
}
