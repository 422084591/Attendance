package service;

import java.util.List;

import dao.LeaveDao;
import dao.LeaveDaoImpl;
import model.Leave;

public class LeaveServiceImpl implements LeaveService<Leave>{
	LeaveDaoImpl dao=new LeaveDaoImpl();
	@Override
	public boolean addLeave(Leave t) {// 添加请假单信息
		// TODO Auto-generated method stub
		return dao.addLeave(t);
	}

	@Override
	public boolean removeLeaveByIds(int[] ids) {// 通过请假单id数组批量删除员工信息
		// TODO Auto-generated method stub
		return dao.removeLeaveByIds(ids);
	}

	@Override
	public boolean deleteLeaveById(int id) {// 通过请假单id删除请假单信息
		// TODO Auto-generated method stub
		return dao.deleteLeaveById(id);
	}

	@Override
	public boolean updateLeaveById(int id, Leave t) {// 通过请假单的id修改请假单的信息
		// TODO Auto-generated method stub
		return dao.updateLeaveById(id, t);
	}

	@Override
	public Leave getLeaveById(int id) {// 通过请假单id来找请假单信息
		// TODO Auto-generated method stub
		return dao.getLeaveById(id);
	}

	@Override
	public List<Leave> getLeaveByPleaseDummyMan(String pleaseDummyMan) {// 通过请假人名字查找请假单
		// TODO Auto-generated method stub
		return dao.getLeaveByPleaseDummyMan(pleaseDummyMan);
	}

	@Override
	public List<Leave> getAllByLimit(int limitNumber) {// 每页找出的请假记录数量
		// TODO Auto-generated method stub
		return dao.getAllByLimit(limitNumber);
	}

	@Override
	public int getMaxPage() { // 当前数据记录一共有几页
		// TODO Auto-generated method stub
		return dao.getMaxPage();
	}

	@Override
	public List<Leave> getAll() { //获取全部信息
		// TODO Auto-generated method stub
		return dao.getAll();
	}
	

}
