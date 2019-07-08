package service;

import java.util.List;

import dao.PunchCardDao;
import dao.PunchCardDaoImpl;
import model.PunchCard;

public class PunchCardServiceImpl implements PunchCardService<PunchCard>{
	PunchCardDaoImpl dao=new PunchCardDaoImpl();
	@Override
	public boolean addPunchCard(PunchCard punchCard) {// 添加打卡单信息
		// TODO Auto-generated method stub
		return dao.addPunchCard(punchCard);
	}

	@Override
	public boolean removePunchCardByIds(int[] ids) {// 通过打卡单id数组批量删除员工信息
		// TODO Auto-generated method stub
		return dao.removePunchCardByIds(ids);
	}

	@Override
	public boolean deletePunchCardById(int id) {// 通过打卡单id删除打卡单信息
		// TODO Auto-generated method stub
		return dao.deletePunchCardById(id);
	}

	@Override
	public boolean updatePunchCardById(int id, PunchCard punchCard) {// 通过打卡单的id修改打卡单的信息
		// TODO Auto-generated method stub
		return dao.updatePunchCardById(id, punchCard);
	}

	@Override
	public PunchCard getPunchCardById(int id) {// 通过打卡单id来找打卡单信息
		// TODO Auto-generated method stub
		return dao.getPunchCardById(id);
	}

	@Override
	public List<PunchCard> getPunchCardByPunchCardMan(String punchCardMan) {// 通过打卡人名字查找打卡单
		// TODO Auto-generated method stub
		return dao.getPunchCardByPunchCardMan(punchCardMan);
	}

	@Override
	public List<PunchCard> getAllByLimit(int limitNumber) {// 每页找出的打卡记录数量
		// TODO Auto-generated method stub
		return dao.getAllByLimit(limitNumber);
	}

	@Override
	public int getMaxPage() {// 当前数据记录一共有几页
		// TODO Auto-generated method stub
		return dao.getMaxPage();
	}

	@Override
	public List<PunchCard> getAll() {// 获取全部记录
		// TODO Auto-generated method stub
		return dao.getAll();
	}
	

}
