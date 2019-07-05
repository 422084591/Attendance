package service;

import java.util.List;

import dao.LeaveDao;
import dao.LeaveDaoImpl;
import model.Leave;

public class LeaveServiceImpl implements LeaveService<Leave>{
	LeaveDaoImpl dao=new LeaveDaoImpl();
	@Override
	public boolean addLeave(Leave t) {
		// TODO Auto-generated method stub
		return dao.addLeave(t);
	}

	@Override
	public boolean removeLeaveByIds(int[] ids) {
		// TODO Auto-generated method stub
		return dao.removeLeaveByIds(ids);
	}

	@Override
	public boolean deleteLeaveById(int id) {
		// TODO Auto-generated method stub
		return dao.deleteLeaveById(id);
	}

	@Override
	public boolean updateLeaveById(int id, Leave t) {
		// TODO Auto-generated method stub
		return dao.updateLeaveById(id, t);
	}

	@Override
	public Leave getLeaveById(int id) {
		// TODO Auto-generated method stub
		return dao.getLeaveById(id);
	}

	@Override
	public List<Leave> getLeaveByPleaseDummyMan(String pleaseDummyMan) {
		// TODO Auto-generated method stub
		return dao.getLeaveByPleaseDummyMan(pleaseDummyMan);
	}

	@Override
	public List<Leave> getAllByLimit(int limitNumber) {
		// TODO Auto-generated method stub
		return dao.getAllByLimit(limitNumber);
	}

	@Override
	public int getMaxPage() {
		// TODO Auto-generated method stub
		return dao.getMaxPage();
	}

	@Override
	public List<Leave> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}
	

}
